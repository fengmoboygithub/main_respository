package com.company.domain.conversion;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.company.base.exception.BaseException;
import com.company.config.interfaceinfo.InterfaceParam;
import com.company.enums.HandleFieldIndexTabType;
import com.company.one.handlefieldindex.dao.HandleFieldIndexTabMapper;
import com.company.one.handlefieldindex.model.HandleFieldIndexTab;
import com.company.one.handlefieldindex.model.HandleFieldIndexTabExample;
import com.company.one.handlefieldindex.model.HandleFieldIndexTabExample.Criteria;
import com.company.one.handleplain.model.HandlePlainTmp;
import com.company.one.handletuple.model.HandleTupleTmp;

/**
 * 将文本内容转化为对应的json内容相关的domain
 * @author yangyanchao
 *
 */
public class ConversionDomain {
	
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(ConversionDomain.class);
	
	/**
	 * 上传路径标识符
	 */
	public final static String UPLOADPATH = "#uploadPath#";
	
	/**
	 * 字段索引--Mapper类
	 */
	@Autowired
    private HandleFieldIndexTabMapper handleFieldIndexTabMapper;
	
	/**
     * 文件内容实体
     */
    private HandlePlainTmp handlePlainTmp;
    
    /**
     * 文件元组内容实体列表
     */
    private List<HandleTupleTmp> handleTupleTmpList;
    
    /**
     * 接口信息参数
     */
    private InterfaceParam interfaceParam;
    
    /**
	 * 字段分隔符
	 */
	private String separator;
	
	public ConversionDomain() {
		super();
	}

	public ConversionDomain(HandlePlainTmp handlePlainTmp, List<HandleTupleTmp> handleTupleTmpList,
			InterfaceParam interfaceParam, String separator) {
		super();
		this.handlePlainTmp = handlePlainTmp;
		this.handleTupleTmpList = handleTupleTmpList;
		this.interfaceParam = interfaceParam;
		this.separator = separator;
	}

	public HandlePlainTmp getHandlePlainTmp() {
		return handlePlainTmp;
	}

	public void setHandlePlainTmp(HandlePlainTmp handlePlainTmp) {
		this.handlePlainTmp = handlePlainTmp;
	}

	public List<HandleTupleTmp> getHandleTupleTmpList() {
		return handleTupleTmpList;
	}

	public void setHandleTupleTmpList(List<HandleTupleTmp> handleTupleTmpList) {
		this.handleTupleTmpList = handleTupleTmpList;
	}

	public InterfaceParam getInterfaceParam() {
		return interfaceParam;
	}

	public void setInterfaceParam(InterfaceParam interfaceParam) {
		this.interfaceParam = interfaceParam;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	/**
	 * 将文本内容转化为对应的json内容
	 */
	public String conversion() throws BaseException {
		String resultJson = "";
		if(handlePlainTmp != null){
			String fileItemContent = handlePlainTmp.getFileItemContent();
			if(!StringUtils.isEmpty(fileItemContent) && fileItemContent.indexOf(separator) > -1){
				//以分隔符分隔成字符数组
				String[] fileItemContentArr = fileItemContent.split(separator);
				
				HandleFieldIndexTabExample example = new HandleFieldIndexTabExample();
				Criteria criteria = example.createCriteria();
				//模板编号
				criteria.andTTemplateTypeEqualTo(interfaceParam.getRela());
				//控件类型 不是 Tuple子项元素和 多附件
				List<String> notInList = new ArrayList<String>();
				notInList.add(HandleFieldIndexTabType.TUPLESON.getCode());
				notInList.add(HandleFieldIndexTabType.MULTIPLE.getCode());
				criteria.andTControlTypeNotIn(notInList);
				example.setOrderByClause(" index_value asc ");
				//获取控件类型 不是 Tuple子项元素和 多附件的字段索引数据
				List<HandleFieldIndexTab> list = handleFieldIndexTabMapper.selectByExample(example);
				
				HandleFieldIndexTabExample example1 = new HandleFieldIndexTabExample();
				Criteria criteria1 = example1.createCriteria();
				//模板编号
				criteria1.andTTemplateTypeEqualTo(interfaceParam.getRela());
				//控件类型 是 Tuple子项元素和 多附件
				List<String> inList = new ArrayList<String>();
				notInList.add(HandleFieldIndexTabType.TUPLESON.getCode());
				notInList.add(HandleFieldIndexTabType.MULTIPLE.getCode());
				criteria1.andTControlTypeIn(inList);
				example1.setOrderByClause(" index_value asc ");
				//获取控件类型 是 Tuple子项元素和 多附件的字段索引数据
				List<HandleFieldIndexTab> list1 = handleFieldIndexTabMapper.selectByExample(example1);
				
				Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
				for(int i=0; i<fileItemContentArr.length; i++){
					HandleFieldIndexTab handleFieldIndexTab = list.get(0);
					HandleFieldIndexTabType type = HandleFieldIndexTabType.getEnumsByCode(handleFieldIndexTab.gettControlType());
					String field = handleFieldIndexTab.getdField();
					//判断控件类型
					switch (type.getCode()) {
						case "0":
							//普通元素
							resultMap.put(field, fileItemContentArr[i]);
							break;
						case "3":
							//单附件
							//resultMap.put(field, fileItemContentArr[i]+separator+UPLOADPATH);
							resultMap.put(field, fileItemContentArr[i]);
							break;
						case "4":
							//Tuple父元素
							List<Map<String,Object>> tupleList = new ArrayList<Map<String,Object>>();
							String tupleName = fileItemContentArr[i];
							if(handleTupleTmpList != null && handleTupleTmpList.size() > 0){
								for(HandleTupleTmp handleTupleTmp : handleTupleTmpList){
									if(tupleName.equals(handleTupleTmp.getTupleName())){
										String tupleItemContent = handleTupleTmp.getTupleItemContent();
										if(!StringUtils.isEmpty(tupleItemContent) && tupleItemContent.indexOf(separator) > -1){
											Map<String,Object> tupleMap = new LinkedHashMap<String,Object>();
											//以分隔符分隔成字符数组
											String[] tupleItemContentArr = tupleItemContent.split(separator);
											for(int count=0; count<tupleItemContentArr.length; count++){
												HandleFieldIndexTab handleFieldIndexTab1 = list1.get(0);
												HandleFieldIndexTabType type1 = HandleFieldIndexTabType.getEnumsByCode(handleFieldIndexTab1.gettControlType());
												String field1 = handleFieldIndexTab1.getdField();
												//判断控件类型
												switch (type1.getCode()) {
													case "1":
														//tuple子项元素
														tupleMap.put(field1, tupleItemContentArr[i]);
														break;
													case "2":
														//多附件
														//tupleMap.put(field1, tupleItemContentArr[i]+separator+UPLOADPATH);
														tupleMap.put(field1, tupleItemContentArr[i]);
														break;
													default:
														break;
												}
											}
											tupleList.add(tupleMap);
										}
									}
								}
							}
							resultMap.put(field, tupleList);
							break;
						default:
							break;
					}
				}
				resultJson = JSON.toJSONString(resultMap);
				//4.String转map
		        //Map<String, Object> stringToMap =  JSONObject.parseObject(""); 
			}
		}
		return resultJson;
	}
}
