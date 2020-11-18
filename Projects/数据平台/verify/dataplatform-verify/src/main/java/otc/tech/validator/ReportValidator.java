package otc.tech.validator;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import otc.tech.model.BusinessRules;
import otc.tech.model.ReportTypes;
import otc.tech.model.Template;
import otc.tech.service.IBusinessRulesService;
import otc.tech.service.ITemplateService;
import otc.tech.storage.CellGroup;
import otc.tech.storage.CellValue;
import otc.tech.storage.FormData;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 报告校验
 */
@Service
public class ReportValidator implements Validator {

	private Options options;

	@Autowired
	private IBusinessRulesService businessRuleService;

	@Autowired
	private ITemplateService templateElementService;

	/**
	 * 报告校验
	 * 
	 * @param options
	 * @return
	 */
	public Map<String, Object> verify(Options options) throws Exception {
		init(options);
		Map<String, Object> map = new HashMap<String, Object>();
		// 基础校验
		List<Map<String, String>> based = this.basedVerify();
		if (!based.isEmpty()) {
			map.put("error", based);
			//return map;
		}

		// 附件是否存在校验
		/*
		 * List<Map<String, String>> filed = this.filedVerify(); if (!filed.isEmpty()) {
		 * map.put("error", filed); return map; }
		 */

		// 业务校验
		if (!this.options.ignoreBusinessVerify) {
			List<Map<String, String>> business = this.businessVerify();
			if (!business.isEmpty()) {
				map.put("businesserror", business);
			}
		}
		return map;
	}

	/**
	 * 中证云衍生品接口校验
	 * 
	 * @param options
	 * @return
	 */
//	public Map<String, Object> autoSendVerify(Options options) throws Exception {
//		init(options);
//		Map<String, Object> map = new HashMap<String, Object>();
//		// 基础校验
//		List<Map<String, String>> based = this.autoSendBasedVerify();
//		if (!based.isEmpty()) {
//			map.put("error", based);
//			return map;
//		}
//
//		// 附件是否存在校验
//		/*
//		 * List<Map<String, String>> filed = this.filedVerify(); if (!filed.isEmpty()) {
//		 * map.put("error", filed); return map; }
//		 */
//
//		// 业务校验
//		if (!this.options.ignoreBusinessVerify) {
//			List<Map<String, String>> business = this.autoSendBusinessVerify();
//			if (!business.isEmpty()) {
//				map.put("error", business);
//			}
//		}
//		return map;
//	}

	/**
	 * 附件是否存在校验
	 * 
	 */
	/*
	 * public List<Map<String, String>> filedVerify() throws Exception{ ReportType
	 * reportType = options.reportType; JSONObject json=options.jsonObject; String
	 * type=reportType.getRelevanceTemplate(); List<Map<String, String>> errors =
	 * new ArrayList<Map<String, String>>(); Map<String, String> error = new
	 * HashMap<String, String>(); //获取附件类型的字段名 List<TemplateElement> fileTemplate =
	 * this.templateElementService .findFileByTemplateType(type); if(null ==
	 * fileTemplate || fileTemplate.size() ==0 ){ return errors; }else{ for
	 * (TemplateElement map : fileTemplate) { JSONObject
	 * dat=json.getJSONObject("data"); int controlType = map.getControlType();
	 * String field=""; if(controlType==3) { field=dat.getString(map.getField());
	 * //截取路径 String[] ary = field.split("|"); String address=ary[1]; File tempFile
	 * = new File("C:\\" + address); if(!tempFile.exists()) { error.put("msg",
	 * "未找到此附件！"); error.put("rule", ary[0]); errors.add(error); } }else
	 * if(controlType==2){ JSONArray dats=dat.getJSONArray(map.getTupleUpName());
	 * for (int i = 0; i < dats.size(); i++) { String t = dats.getString(i);
	 * JSONObject we = JSONObject.fromObject(t); String
	 * fieldValue=we.getString(map.getField()); String[] ary =
	 * fieldValue.split("\\|"); String address=ary[1]; File tempFile = new File(
	 * "C:\\" + address); if(!tempFile.exists()) { error.put("msg", "未找到此附件！");
	 * error.put("rule", ary[0]); errors.add(error); } } }
	 * 
	 * } return errors;
	 * 
	 * } }
	 */
	/**
	 * 初始化参数
	 * 
	 */
	private void init(Options options) throws Exception {
		this.options = options;
		if (options == null) {
			throw new Exception(" 校验失败：报告校验 入参 options 不能为空！ ");
		}
		if (options.jsonObject == null) {
			throw new Exception(" 校验失败：报告校验数据 options.jsonObject 不能为空！ ");
		}
		if (options.reportType == null) {
			throw new Exception(" 校验失败：报告类型 options.reportType 不能为空！ ");
		}
		if (options.formData == null) {
			options.formData = jsonObjectToFormData();
		}
	}

	/**
	 * 将JSON数据封装成formData对象
	 * 
	 * @return
	 * @throws Exception
	 */
	public FormData jsonObjectToFormData() throws Exception {
		FormData formData = new FormData();
		ReportTypes reportType = options.reportType;
		JSONObject jsonObject = options.jsonObject;
		JSONObject jsonData = JSONObject.parseObject(jsonObject.get("data").toString());
		if (jsonData.isEmpty()) {
			return formData;
		}
		List<Template> elements = templateElementService.findByTemplateType(reportType.gettTemplateType());
		options.elements = elements;
		Integer it=0;//tuple的id  不能重复
		for (Template element : elements) {
			Object value = null;
			String field = element.getdField();
			// 是否Tuple元素
			Boolean isTuple = element.getIsAbstract();
			if (jsonData.get(field) == null) {//tuple里的字段不在第一层级内，取不到就排除了，跟格式有关
				if (!isTuple) {
					continue;
				}
			}
			value = jsonData.get(field);
			if (isTuple) {
				List<Template> children = element.getChildren();//取出所有子元素
				if (value.toString().equals("[]") || children.isEmpty()) {//判断[]根据传参来定，不影响
					continue;
				}
				JSONArray jsonArray = JSONArray.parseArray(value.toString());//所有tuple值
				for (Object object : jsonArray) {
					JSONObject jsonParent = JSONObject.parseObject(object.toString());//一个tuple的值
					//String tupleId = jsonParent.get("SORT") != null ? jsonParent.getString("SORT") : "";
					it++;//不能重复 不使用给出的排序id 自己定义
//					if (StringUtils.isBlank(tupleId)) {
//						tupleId = jsonParent.get("ID") != null ? jsonParent.getString("ID")
//								: UUID.randomUUID().toString().replace("-", "");
//					}
					// 创建group
					CellGroup group = new CellGroup();
					group.setId(it.toString());
					group.setGroupType(CellGroup.GROUP_TUPLE);
					group.setConceptName(element.getdField());
					group.setName(formData.getCellGroupName(group.getParentId(), group.getConceptName()));
					if (StringUtils.isBlank(group.getName())) {//groupNAME随机UID
						group.setName(UUID.randomUUID().toString());
					}
					for (Template child : children) {
						String cField = child.getdField();
						if (jsonParent.get(cField) == null) {
							continue;
						}
						String cValue = jsonParent.getString(cField);//单个tuple中一个元素的值
						CellValue cellValue = new CellValue();
						cellValue.setName(cField);
						cellValue.setValue(StringUtils.trim(cValue));
						cellValue.setText(StringUtils.trim(cValue));
						cellValue.setFieldType(child.getdFieldType());
						cellValue.setElementName(child.gettElementName());
						cellValue.setGroupId(group.getId());
						formData.getCellValues().add(cellValue);
					}
					// 记录tuple顺序
					List<String> list = formData.getOrderedGroups().get(group.getName());
					
					String tupleId = jsonParent.get("SORT") != null ? jsonParent.getString("SORT") : "";
					if (StringUtils.isBlank(tupleId)) {//记录tuple顺序ID是报告给出的
						tupleId = jsonParent.get("ID") != null ? jsonParent.getString("ID")
								: UUID.randomUUID().toString().replace("-", "");
					}
					if (list == null) {
						list = new LinkedList<String>();
						
						list.add(group.getId()+"|"+tupleId);
						formData.getOrderedGroups().put(group.getName(), list);
					} else {
						if (!list.contains(group.getId()+"|"+tupleId)) {
							list.add(group.getId()+"|"+tupleId);
						}
					}
					formData.getCellGroups().add(group);
				}
			} else {
				CellValue cellValue = new CellValue();
				cellValue.setName(field);
				cellValue.setFieldType(element.getdFieldType());
				cellValue.setElementName(element.gettElementName());
				cellValue.setValue(StringUtils.trim((String) value));
				cellValue.setText(StringUtils.trim((String) value));
				formData.getCellValues().add(cellValue);
			}
		}
		return formData;
	}

	/**
	 * 基础数据校验
	 * 
	 * @return
	 * @throws Exception
	 */
	private List<Map<String, String>> basedVerify() throws Exception {

		FormData data = options.formData;
		//ReportTypes reportType = options.reportType;
		List<CellValue> cellValues = data.getCellValues();

		if (cellValues == null || cellValues.isEmpty()) {
			return new ArrayList<Map<String, String>>();
		}

		List<CellGroup> cellIndex = data.getCellGroups();
		Map<String, List<String>> orderIndex = data.getOrderedGroups();
		List<Map<String, String>> errors = new ArrayList<Map<String, String>>();

//		List<Template> baseRules = this.templateElementService
//				.findAllByTemplateType(reportType.gettTemplateType());

		for (CellValue cv : cellValues) {
			//String cellName = cv.getName();
			String cellValue = cv.getValue();
			if (StringUtils.isBlank(cellValue)) {
				continue;
			}
//			for (Template entry : baseRules) {//废弃
//				if (!StringUtils.equalsIgnoreCase(cellName, entry.getdField())) {
//					continue;//判断存在隐患，cellName在同一报告里是有重复字段的，但目前重复字段的效验规则和类型是一致的所以并无问题，今后建立字段名称避免重复
//				}
				MappingConfig config = MappingConfig.adaptive(cv);
				if(config == null) {
					continue;
				}
				String label = config.getColumnName();
				String fieldName = config.getFieldName();

				if (config.isDate()) {// 时间类型
					boolean isDate = cellValue.matches(
							"^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)?$");
					boolean isDate2 = cellValue.matches(
							"^([1-2]\\d{3})[\\/|\\-](0?[1-9]|10|11|12)[\\/|\\-]([1-2]?[0-9]|0[1-9]|30|31)(\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9]))?$");
					if (!(isDate || isDate2)) {
						if (cv.getGroupId() != null) {
							Map<String, String> error = new HashMap<String, String>();
							String indexs = "";
							indexs = rowLine(cv, orderIndex, cellIndex);
							// indexs = cv.getGroupId();//根据前端入参SORT为行号;
							error.put("msg", indexs + label + ":不是合理的DateTime类型，请修改!");
							error.put("rule", fieldName);
							error.put("errcode", "-1005");
							errors.add(error);
						} else {
							Map<String, String> error = new HashMap<String, String>();
							error.put("msg", label + ":不是合理的DateTime类型，请修改!");
							error.put("rule", fieldName);
							error.put("errcode", "-1005");
							errors.add(error);
						}
						continue;
					}
				} else if (config.isDecimal()) { // 数字类型
					// boolean isNum = cellValue
					// .matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
					boolean isNum = cellValue.matches("^([-+]?([0-9]+)([.]([0-9]+))?|([.]([0-9]+)))?$");
					if (!isNum) {
						if (cv.getGroupId() != null) {
							Map<String, String> error = new HashMap<String, String>();
							String indexs = "";
							indexs = rowLine(cv, orderIndex, cellIndex);
							// indexs = cv.getGroupId();//根据前端入参SORT为行号;
							error.put("msg", indexs + label + ":不是数字类型，请修改!");
							error.put("rule", fieldName);
							error.put("errcode", "-1005");
							errors.add(error);
						} else {
							Map<String, String> error = new HashMap<String, String>();
							error.put("msg", label + ":不是数字类型，请修改!");
							error.put("rule", fieldName);
							error.put("errcode", "-1005");
							errors.add(error);
						}
						continue;
					}
					if (config.getNumberLength() > 0 && cellValue.length() > config.getNumberLength()) {
						if (cv.getGroupId() != null) {
							Map<String, String> error = new HashMap<String, String>();
							String indexs = "";
							indexs = rowLine(cv, orderIndex, cellIndex);
							// indexs = cv.getGroupId();//根据前端入参SORT为行号;
							error.put("msg", indexs + label + ":长度超出长度范围[" + config.getNumberLength() + "]，请修改!");
							error.put("rule", fieldName);
							error.put("errcode", "-1002");
							errors.add(error);
						} else {
							Map<String, String> error = new HashMap<String, String>();
							error.put("msg", label + ":长度超出长度范围[" + config.getNumberLength() + "]，请修改!");
							error.put("rule", fieldName);
							error.put("errcode", "-1002");
							errors.add(error);
						}
						continue;
					}
				} else if (config.isVarchar()) { // 字符类型
					int length = getDateLength(cellValue);
					if (length > config.getVarcharLength()) {
						if (cv.getGroupId() != null) {
							Map<String, String> error = new HashMap<String, String>();
							String indexs = "";
							indexs = rowLine(cv, orderIndex, cellIndex);
							// indexs = cv.getGroupId();//根据前端入参SORT为行号;
							error.put("msg", indexs + label + ":长度超出范围[" + config.getVarcharLength() + "]，请修改!");
							error.put("rule", fieldName);
							error.put("errcode", "-1002");
							errors.add(error);
						} else {
							Map<String, String> error = new HashMap<String, String>();
							error.put("msg", label + ":长度超出范围[" + config.getVarcharLength() + "]，请修改!");
							error.put("rule", fieldName);
							error.put("errcode", "-1002");
							errors.add(error);
						}
						continue;
					}
				} else if (config.isClob()) {// clob
					int length = getDateLength(cellValue);
					if (length > 8000) {
						if (cv.getGroupId() != null) {
							Map<String, String> error = new HashMap<String, String>();
							String indexs = "";
							indexs = rowLine(cv, orderIndex, cellIndex);
							// indexs = cv.getGroupId();//根据前端入参SORT为行号;
							error.put("msg", indexs + label + ":长度不能大于四千汉字，请修改!");
							error.put("rule", fieldName);
							error.put("errcode", "-1002");
							errors.add(error);
						} else {
							Map<String, String> error = new HashMap<String, String>();
							error.put("msg", label + ":长度不能大于四千汉字，请修改!");
							error.put("rule", fieldName);
							error.put("errcode", "-1002");
							errors.add(error);
						}
						continue;
					}
				}
		//	}
		}
		return errors;
	}

	/**
	 * 中证云衍生品基础数据校验
	 * 
	 * @return
	 * @throws Exception
	 */
	// private List<Map<String, String>> autoSendBasedVerify() throws Exception {
	//
	// FormData data = options.formData;
	// ReportType reportType = options.reportType;
	// List<CellValue> cellValues = data.getCellValues();
	//
	// if (cellValues == null || cellValues.isEmpty()) {
	// return new ArrayList<Map<String, String>>();
	// }
	//
	// List<CellGroup> cellIndex = data.getCellGroups();
	// Map<String, List<String>> orderIndex = data.getOrderedGroups();
	// List<Map<String, String>> errors = new ArrayList<Map<String, String>>();
	//
	// List<TemplateElement> baseRules = this.templateElementService
	// .findAllByTemplateType(reportType.getRelevanceTemplate());
	//
	// for (CellValue cv : cellValues) {
	// String cellName = cv.getName();
	// String cellValue = cv.getValue();
	// if (StringUtils.isBlank(cellValue)) {
	// continue;
	// }
	// for (TemplateElement entry : baseRules) {
	// MappingConfig config = MappingConfig.adaptive(entry);
	// if (!StringUtils.equalsIgnoreCase(cellName, entry.getField())
	// || config == null) {
	// continue;
	// }
	// String label = config.getColumnName();
	// String fieldName = config.getConceptID();
	//
	// if (config.isDate()) { // 时间类型
	// boolean isDate = cellValue
	// .matches("^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)?$");
	// boolean isDate2 = cellValue
	// .matches("^([1-2]\\d{3})[\\/|\\-](0?[1-9]|10|11|12)[\\/|\\-]([1-2]?[0-9]|0[1-9]|30|31)(\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9]))?$");
	// if (!(isDate || isDate2)) {
	// if (cv.getGroupId() != null) {
	// Map<String, String> error = new HashMap<String, String>();
	// String indexs = "";
	// indexs = rowLine(cv, orderIndex, cellIndex);
	//// indexs = cv.getGroupId();//根据前端入参SORT为行号;
	// error.put("msg", indexs + label
	// + ":不是合理的DateTime类型，请修改!");
	// error.put("rule", fieldName);
	// errors.add(error);
	// } else {
	// Map<String, String> error = new HashMap<String, String>();
	// error.put("msg", label + ":不是合理的DateTime类型，请修改!");
	// error.put("rule", fieldName);
	// errors.add(error);
	// }
	// break;
	// }
	// } else if (config.isDecimal()) { // 数字类型
	// boolean isNum = cellValue
	// .matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	// if (!isNum) {
	// if (cv.getGroupId() != null) {
	// Map<String, String> error = new HashMap<String, String>();
	// String indexs = "";
	// indexs = rowLine(cv, orderIndex, cellIndex);
	//// indexs = cv.getGroupId();//根据前端入参SORT为行号;
	// error.put("msg", indexs + label + ":不是数字类型，请修改!");
	// error.put("rule", fieldName);
	// errors.add(error);
	// } else {
	// Map<String, String> error = new HashMap<String, String>();
	// error.put("msg", label + ":不是数字类型，请修改!");
	// error.put("rule", fieldName);
	// errors.add(error);
	// }
	// break;
	// }
	// if (config.getNumberLength() > 0
	// && cellValue.length() > config.getNumberLength()) {
	// if (cv.getGroupId() != null) {
	// Map<String, String> error = new HashMap<String, String>();
	// String indexs = "";
	// indexs = rowLine(cv, orderIndex, cellIndex);
	//// indexs = cv.getGroupId();//根据前端入参SORT为行号;
	// error.put("msg", indexs + label + ":长度超出长度范围["
	// + config.getNumberLength() + "]，请修改!");
	// error.put("rule", fieldName);
	// errors.add(error);
	// } else {
	// Map<String, String> error = new HashMap<String, String>();
	// error.put(
	// "msg",
	// label + ":长度超出长度范围["
	// + config.getNumberLength()
	// + "]，请修改!");
	// error.put("rule", fieldName);
	// errors.add(error);
	// }
	// break;
	// }
	// } else if (config.isVarchar()) { // 字符类型
	// int length = getDateLength(cellValue);
	// if (length > config.getVarcharLength()) {
	// if (cv.getGroupId() != null) {
	// Map<String, String> error = new HashMap<String, String>();
	// String indexs = "";
	// indexs = rowLine(cv, orderIndex, cellIndex);
	//// indexs = cv.getGroupId();//根据前端入参SORT为行号;
	// error.put("msg", indexs + label + ":长度超出范围["
	// + config.getVarcharLength() + "]，请修改!");
	// error.put("rule", fieldName);
	// errors.add(error);
	// } else {
	// Map<String, String> error = new HashMap<String, String>();
	// error.put(
	// "msg",
	// label + ":长度超出范围["
	// + config.getVarcharLength()
	// + "]，请修改!");
	// error.put("rule", fieldName);
	// errors.add(error);
	// }
	// break;
	// }
	// } else if (config.isClob()) {// clob
	// int length = getDateLength(cellValue);
	// if (length > 12000) {
	// if (cv.getGroupId() != null) {
	// Map<String, String> error = new HashMap<String, String>();
	// String indexs = "";
	// indexs = rowLine(cv, orderIndex, cellIndex);
	//// indexs = cv.getGroupId();//根据前端入参SORT为行号;
	// error.put("msg", indexs + label
	// + ":长度不能大于六千汉字，请修改!");
	// error.put("rule", fieldName);
	// errors.add(error);
	// } else {
	// Map<String, String> error = new HashMap<String, String>();
	// error.put("msg", label + ":长度不能大于六千汉字，请修改!");
	// error.put("rule", fieldName);
	// errors.add(error);
	// }
	// break;
	// }
	// }
	// }
	// }
	// return errors;
	// }
	/**
	 * 获得字符串字节数
	 * 
	 * @param cellValue
	 * @return
	 */
	private int getDateLength(String cellValue) {
		int length = 0;
		cellValue = cellValue.trim();// 去除前后空格
		try {
			cellValue = cellValue.replace("\n", "**").replace("\r", "**");
			length = new String(cellValue.getBytes("gb2312"), "iso-8859-1").length();
		} catch (UnsupportedEncodingException e) {
			length = cellValue.length();
		}
		return length;
	}

	/**
	 * 返回行数
	 * 
	 * @return
	 */
	private String rowLine(CellValue cv, Map<String, List<String>> orderIndex, List<CellGroup> cellIndex) {
		int rowNumber = 0;
		String str = "";
		for (CellGroup cellGroup : cellIndex) {
			if (cellGroup.getId().equals(cv.getGroupId())) {
				List<String> orderList = orderIndex.get(cellGroup.getName());
				for (int i = 0; i < orderList.size(); i++) {
					String[] tmp = orderList.get(i).split("\\|");
					if ( tmp[0].equals(cv.getGroupId())) {
						rowNumber = (i + 1);
						str = "第" + rowNumber + "行";
					}
				}
			}
		}
		return str;
	}

	/**
	 * 数据业务校验（支持必填、联动必填、正表达式等）</br>
	 * 支持Tuple格式数据校验
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, String>> businessVerify() throws Exception {
		final FormData formData = options.formData;
		//ReportTypes reportType = options.reportType;
		List<Template> list = options.elements;
		//List<Template> list = this.templateElementService.findByTemplateType(reportType.gettTemplateType());//优化掉
		List<Map<String, String>> errors = new ArrayList<Map<String, String>>();
		Map<String, BusinessRules> businessRuleMap = this.businessRuleService.findMap();

		for (Template e : list) {
			if (e.getIsAbstract()) {
				for (Template ce : e.getChildren()) {
					String validateRules = ce.gettValidateRules();
					if (StringUtils.isEmpty(validateRules)) {
						continue;
					}

					List<BusinessRules> rules = getBusinessRules(businessRuleMap, ce, validateRules);
					for (CellGroup group : formData.getCellGroups()) {
						if (!StringUtils.equalsIgnoreCase(group.getConceptName(), e.getdField())) {
							continue;
						}
						CellValue cellValue = formData.getCellValue(group.getId(), ce.getdField());
						if (cellValue == null && group.getId() != null) {
							cellValue = new CellValue();
							cellValue.setGroupId(group.getId());
						}
						Map<String, String> error = this.businessVerify(rules, cellValue);
						if (error!=null) {
							Map<String, String> map = new HashMap<String, String>();
							// map.put(e.getField() + "[SORT:" + group.getId() +" '"+ce.getField() +"' ] ",
							// errorMsg);
							String errorMsg = error.get("msg").replace("：", ",");
							String indexs = null;
							List<String> orderList = formData.getOrderedGroups().get(group.getName());
							for (int i = 0; i < orderList.size(); i++) {
								String[] tmp = orderList.get(i).split("\\|");
								if (tmp[0].equals(group.getId())) {
									int rowNumber = (i + 1);
									indexs = "第" + rowNumber + "行";
								}
							}

							map.put("msg", indexs + ce.gettElementName() + ":" + errorMsg);
							map.put("rule", ce.getdField());
							if(error.containsKey("errcode")) {
								map.put("errcode", error.get("errcode"));
							}else {
								map.put("errcode", "-1002");
							}
							errors.add(map);
						}
					}
				}
			} else {
				if(e.gettControlType().equals(1)) {
					continue;
				}
				String validateRules = e.gettValidateRules();
				if (StringUtils.isEmpty(validateRules)) {
					continue;
				}
				List<BusinessRules> rules = getBusinessRules(businessRuleMap, e, validateRules);
				CellValue cellValue = formData.getCellValue(null, e.getdField());
				Map<String, String> error = this.businessVerify(rules, cellValue);
				if (error!=null) {
					Map<String, String> map = new HashMap<String, String>();
					// map.put(e.getField(), errorMsg);
					String errorMsg = error.get("msg").replace("：", ",");
					map.put("msg", e.gettElementName() + ":" + errorMsg);
					map.put("rule", e.getdField());
					if(error.containsKey("errcode")) {
						map.put("errcode", error.get("errcode"));
					}else {
						map.put("errcode", "-1002");
					}
					errors.add(map);
				}
			}
		}
		return errors;
	}

	/**
	 * 中证云衍生品 -数据业务校验（支持必填、联动必填、正表达式等）</br>
	 * 支持Tuple格式数据校验
	 * 
	 * @return
	 * @throws Exception
	 */
	// public List<Map<String, String>> autoSendBusinessVerify() throws Exception {
	// final FormData formData = options.formData;
	// ReportType reportType = options.reportType;
	//
	// List<Map<String, String>> errors = new ArrayList<Map<String, String>>();
	// List<TemplateElement> list = this.templateElementService
	// .findByTemplateType(reportType.getRelevanceTemplate());
	// Map<String, BusinessRule> businessRuleMap = this.businessRuleService
	// .findMap();
	//
	// for (TemplateElement e : list) {
	// if (e.getIsAbstract()) {
	// for (TemplateElement ce : e.getChildren()) {
	// String validateRules = ce.getValidateRules();
	// if (StringUtils.isEmpty(validateRules)) {
	// continue;
	// }
	//
	// List<BusinessRule> rules = getBusinessRules(
	// businessRuleMap, e, validateRules);
	// for (CellGroup group : formData.getCellGroups()) {
	// if (!StringUtils.equalsIgnoreCase(
	// group.getConceptName(), e.getField())) {
	// continue;
	// }
	// CellValue cellValue = formData.getCellValue(
	// group.getId(), ce.getField());
	// String errorMsg = this.businessVerify(rules, cellValue);
	// if (StringUtils.isNotBlank(errorMsg)) {
	// Map<String, String> map = new HashMap<String, String>();
	//// map.put(e.getField() + "[SORT:" + group.getId() +" '"+ce.getField() +"' ]
	// ",
	//// errorMsg);
	// errorMsg=errorMsg.replace("：",",");
	// String indexs = "第"+group.getId()+"行";
	// map.put("msg",indexs+ce.getElementName()+":"+errorMsg);
	// map.put("rule",ce.getElementId());
	// errors.add(map);
	// }
	// }
	// }
	// } else {
	// String validateRules = e.getValidateRules();
	// if (StringUtils.isEmpty(validateRules)) {
	// continue;
	// }
	// List<BusinessRule> rules = getBusinessRules(businessRuleMap, e,
	// validateRules);
	// CellValue cellValue = formData.getCellValue(null, e.getField());
	// String errorMsg = this.businessVerify(rules, cellValue);
	// if (StringUtils.isNotBlank(errorMsg)) {
	// Map<String, String> map = new HashMap<String, String>();
	//// map.put(e.getField(), errorMsg);
	// errorMsg=errorMsg.replace("：",",");
	// map.put("msg",e.getElementName()+":"+errorMsg);
	// map.put("rule",e.getElementId());
	// errors.add(map);
	// }
	// }
	// }
	// return errors;
	// }
	/**
	 * 获取业务校验规则
	 * 
	 * @param ruleMap
	 * @param element
	 * @param ruleStr
	 * @return
	 */
	private List<BusinessRules> getBusinessRules(Map<String, BusinessRules> ruleMap, Template element, String ruleStr) {
		List<BusinessRules> rules = new ArrayList<BusinessRules>();
		for (String rule : Arrays.asList(ruleStr.split(","))) {
			BusinessRules br = ruleMap.get(rule);
			if (br == null) {
				continue;
			}
			// 设置附件校验规则
			int controlType = element.gettControlType();
			if ((controlType == 2 || controlType == 3)
					&& ArrayUtils.contains("required,linkage".split(","), br.getrType())) {
				BusinessRules tempRule = new BusinessRules();
				tempRule.setrType("attachmentRequired");
				tempRule.setRemark("格式错误：附件文件未找到！");
				tempRule.setrContent("test");
				rules.add(tempRule);
			}
			rules.add(ruleMap.get(rule));
		}
		return rules;
	}

	private Map<String, String> businessVerify(List<BusinessRules> rules, CellValue cellValue) throws Exception {
		Map<String, String> error = new HashMap<String, String>();
		String msg = "";
		final FormData formData = options.formData;
		String Value = cellValue != null ? cellValue.getValue() : "";

		for (BusinessRules obj : rules) {

			String rule = obj.getrContent();
			if (rule.indexOf("@comma") > -1) {
				rule = rule.replaceAll("@comma", "，");
			}
			msg = obj.getRemark();
			if (msg.indexOf("@comma") > -1) {
				msg = msg.replaceAll("@comma", "，");
			}
			// 当msg中有@label 替换成'该值'
			if (msg.indexOf("@label") > -1) {
				msg = msg.replaceAll("@label", "该值");
			}
			if (msg.indexOf("@semicolon") > -1) {
				msg = msg.replaceAll("@semicolon", "\"");
			}

			switch (obj.getrType()) {
			case "compareValidator": // 数字比对
				if (!compareValidator(Value, rule)) {
					error.put("msg", msg);
					return error;
				}
				continue;
			case "required": // 必填
				if (!checkRequired(Value)) {
					error.put("msg", msg);
					error.put("errcode", "-1003");
					return error;
				}
				continue;
			case "purview": // 范围判断
				if (StringUtils.isNotBlank(Value) && !StringUtils.equals(Value, "请选择")) {
					String[] array = Value.split("，");
					String[] ruleArray = rule.split("，");
					if (!arraysContainsArrays(ruleArray, array)) {
						error.put("msg", msg);
						return error;
					}
				}
				continue;
			case "regexp": // 正则表达式
				if (StringUtils.isNotBlank(Value)) {
					if (!Value.matches(rule)) {
						error.put("msg", msg);
						return error;
					}
				}
				continue;
			case "suffix": //后缀格式是否真确PDF,EXCEL
				if (StringUtils.isNotBlank(Value)) {
					String suffix = Value.substring(Value.lastIndexOf(".") + 1, Value.length())
							.toUpperCase();
					if (!ArrayUtils.contains(rule.split(","), suffix)) {
						error.put("msg", msg);
						return error;
					}
				}
				continue;
			case "attachmentRequired": // 校验附件是否存在（即，是否上传到文件存储）
				if (StringUtils.isBlank(Value)) {
					continue;
				}
				// TODO: 验证附件是否存在，该功能预留
				continue;
			case "linkage": // 条件联动非空校验
				if (!(rule.indexOf('^') > -1 && rule.indexOf('$') > -1)) {
					continue;
				}
				String tempRule = rule;
				tempRule = tempRule.replaceAll("\\^", "").replaceAll("\\$", "");//开头结尾
				tempRule = tempRule.replaceAll("\\[", "").replaceAll("\\]", "##");//分割多个
				tempRule = tempRule.replaceAll("\\{", "").replaceAll("\\}", "");

				// 判断是否取反
				boolean isNegation = false;
				int a = tempRule.indexOf('!');
				int b = tempRule.indexOf('！');
				if (a - b > 0 || b - a > 0) {
					isNegation = true;
					tempRule = tempRule.substring(1, tempRule.length());
				}
				String[] linkageRule = tempRule.split("##");
				// -- end

				if (linkageRule.length == 0) {
					continue;
				}

				for (String lr : linkageRule) {
					int index = lr.indexOf("|");
					if (lr.indexOf("|") <= -1) {
						continue;
					}

					String linkageGUID = lr.substring(0, index);
					String linkageValue = lr.substring(index + 1);
					//不应该从被校验元素找同层中的上级
					//CellValue cv = formData.getCellValue(cellValue != null ? cellValue.getGroupId() : "", linkageGUID);
					CellValue cv = formData.getCellValue("", linkageGUID);
					if (cv == null) {
						continue;
					}
					String linkageSpanVal = cv.getValue();
					if (StringUtils.equalsIgnoreCase("NULL", linkageValue)) {
						if (checkRequired(linkageSpanVal)) {
							continue;
						}
					} else if (StringUtils.equalsIgnoreCase("NOTNULL", linkageValue)) {
						if (!checkRequired(linkageSpanVal)) {
							continue;
						}
					} else {
						if (linkageValue.indexOf(',') > -1) {
							if (!Arrays.asList(linkageValue.split(",")).contains(linkageSpanVal)) {
								continue;
							}
						} else {
							if (noEquals(linkageValue, linkageSpanVal)) {
								continue;
							}
						}
					}
					boolean isPass = checkRequired(Value);
					if (isNegation) {
						isPass = !isPass;
					}
					if (!isPass) {
						error.put("msg", msg);
						return error;
					}
				}
				continue;
			case "linkageAndRegexp": // 条件联动正则表达式校验
				if (!(rule.indexOf('^') > -1 && rule.indexOf('$') > -1)) {
					continue;
				}
				String[] ruleList = rule.split("`");
				String splitLinkageRule = ruleList[0];
				String RegexpRule = ruleList[1];
				String lrtempRule = splitLinkageRule;
				lrtempRule = lrtempRule.replaceAll("\\^", "").replaceAll("\\$", "");
				lrtempRule = lrtempRule.replaceAll("\\[", "").replaceAll("\\]", "##");
				lrtempRule = lrtempRule.replaceAll("\\{", "").replaceAll("\\}", "");

				// 判断是否取反
				boolean lrisNegation = false;
				int lra = lrtempRule.indexOf('!');
				int lrb = lrtempRule.indexOf('！');
				if (lra - lrb > 0 || lrb - lra > 0) {
					lrisNegation = true;
					lrtempRule = lrtempRule.substring(1, lrtempRule.length());
				}
				String[] lrlinkageRule = lrtempRule.split("##");
				// -- end

				if (lrlinkageRule.length == 0) {
					continue;
				}

				for (String lr : lrlinkageRule) {
					int index = lr.indexOf("|");
					if (lr.indexOf("|") <= -1) {
						continue;
					}

					String linkageGUID = lr.substring(0, index);
					String linkageValue = lr.substring(index + 1);

					CellValue cv = formData.getCellValue(cellValue != null ? cellValue.getGroupId() : "", linkageGUID);
					if (cv == null) {
						continue;
					}
					String linkageSpanVal = cv.getValue();
					if (StringUtils.equalsIgnoreCase("NULL", linkageValue)) {
						if (checkRequired(linkageSpanVal)) {
							continue;
						}
					} else if (StringUtils.equalsIgnoreCase("NOTNULL", linkageValue)) {
						if (!checkRequired(linkageSpanVal)) {
							continue;
						}
					} else {
						if (linkageValue.indexOf(',') > -1) {
							if (!Arrays.asList(linkageValue.split(",")).contains(linkageSpanVal)) {
								continue;
							}
						} else {
							if (noEquals(linkageValue, linkageSpanVal)) {
								continue;
							}
						}
					}
					boolean isPass = Value.matches(RegexpRule);
					if (lrisNegation) {
						isPass = !isPass;
					}
					if (!isPass) {
						error.put("msg", msg);
						return error;
					}
				}
				continue;
			}
		}
		return null;
	}

	/**
	 * 不等于
	 * 
	 * @param target
	 * @param f
	 * @return
	 */
	private boolean noEquals(String target, String f) {

		// ^{[_GBC_faf339ae1c8d493094ca3590ff463b12|N-NEQ0.00]}$

		final String NEQ = "NEQ";
		final String N_NEQ = "N-NEQ";

		boolean isNumber = false;
		boolean isNegation = false;

		if (StringUtils.startsWith(target, NEQ)) {
			isNegation = true;
			target = target.substring(NEQ.length(), target.length());
		} else if (StringUtils.startsWith(target, N_NEQ)) {
			isNumber = true;
			isNegation = true;
			target = target.substring(N_NEQ.length(), target.length());
		}

		try {
			if (isNumber) {
				BigDecimal _a = new BigDecimal(f);
				BigDecimal _b = new BigDecimal(target);
				boolean b = _a.compareTo(_b) != 0;
				if (isNegation) {
					b = !b;
				}
				return b;
			}
		} catch (Exception e) {
			// 继续执行
		}

		boolean b = !StringUtils.equals(target, f);
		if (isNegation) {
			b = !b;
		}
		return b;

	}

	/**
	 * 大于小于校验
	 * 
	 * @param value
	 * @return
	 * @throws Exception 
	 */
	private boolean compareValidator(String value, String rule) throws Exception {
		try {
			
		
		String[] tmp = rule.split("\\|");
		String sign = tmp[0];
		BigDecimal bigValue = new BigDecimal(value);
		BigDecimal bigRule = new BigDecimal(tmp[1]);
		
		if (sign.equals(">>")) {
			return bigValue.compareTo(bigRule) == 1;
		} else if (sign.equals("<<")) {
			return bigValue.compareTo(bigRule) == -1;
		} else if (sign.equals(">=")) {
			if (bigValue.compareTo(bigRule) == 1 || bigValue.compareTo(bigRule) == 0) {
				return true;
			} else {
				return false;
			}
		} else if (sign.equals("<=")) {
			if (bigValue.compareTo(bigRule) == -1 || bigValue.compareTo(bigRule) == 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		} catch (Exception e) {
			throw new Exception("数字对比校验出错");
		}
	}

	/**
	 * 非空校验
	 * 
	 * @param value
	 * @return
	 */
	private boolean checkRequired(String value) {
		if (StringUtils.isNotBlank(value)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断数组a是否在数组b中都存在
	 * 
	 * @param array1
	 * @param array2
	 * @return
	 */
	private boolean arraysContainsArrays(String[] array1, String[] array2) {
		boolean boo = true;
		if (array1 == null || array2 == null) {
			return boo;
		}
		for (String e : array2) {
			boo = ArrayUtils.contains(array1, e);
			if (!boo) {
				return boo;
			}
		}
		return boo;
	}

}
