package com.interapi.app.modular.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.model.BaseOption;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.modular.dao.DictionariesTabMapper;
import com.interapi.app.modular.dao.ElementTabMapper;
import com.interapi.app.modular.dao.FormItemTabMapper;
import com.interapi.app.modular.dao.ModularFieldTabMapper;
import com.interapi.app.modular.dao.ModularTabMapper;
import com.interapi.app.modular.dao.QueryCriteriaItemTabMapper;
import com.interapi.app.modular.dao.RulesTabMapper;
import com.interapi.app.modular.dao.TableItemTabMapper;
import com.interapi.app.modular.model.DictionariesTab;
import com.interapi.app.modular.model.DictionariesTabExample;
import com.interapi.app.modular.model.ElementTab;
import com.interapi.app.modular.model.ElementTabExample;
import com.interapi.app.modular.model.FormItemTab;
import com.interapi.app.modular.model.FormItemTabExample;
import com.interapi.app.modular.model.ModularFieldTab;
import com.interapi.app.modular.model.ModularFieldTabExample;
import com.interapi.app.modular.model.ModularTab;
import com.interapi.app.modular.model.ModularTabExample;
import com.interapi.app.modular.model.QueryCriteriaItemTab;
import com.interapi.app.modular.model.QueryCriteriaItemTabExample;
import com.interapi.app.modular.model.RulesTab;
import com.interapi.app.modular.model.RulesTabExample;
import com.interapi.app.modular.model.TableItemTab;
import com.interapi.app.modular.model.TableItemTabExample;
import com.interapi.app.modular.service.ModularTabService;
import com.interapi.app.utils.StringUtil;

@Service
public class ModularTabServiceImpl extends BaseServiceImpl<ModularTab, ModularTabExample> implements ModularTabService<ModularTab, ModularTabExample>{

    @Autowired
    private ModularTabMapper mapper;
    
    @Autowired
    private ModularFieldTabMapper modularFieldTabMapper;
    
    @Autowired
    private QueryCriteriaItemTabMapper queryCriteriaItemTabMapper;
    
    @Autowired
    private ElementTabMapper elementTabMapper;
    
    @Autowired
    private RulesTabMapper rulesTabMapper;
    
    @Autowired
    private TableItemTabMapper tableItemTabMapper;
    
    @Autowired
    private FormItemTabMapper formItemTabMapper;
    
    @Autowired
    private DictionariesTabMapper dictionariesTabMapper;
	
	public IBaseDao<ModularTab, ModularTabExample> getMapper(){
		return mapper;
	}

	@Override
	public Map<String, List> getFieldsById(Long id) {
		Map<String, List> map = new HashMap<String, List>();
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		List<String> value = new ArrayList<String>();
		//通过模块id查询模块信息
		ModularTab modularTab = mapper.selectByPrimaryKey(id);
    	//通过模块表名和实例名 查询所有列信息
    	List<ModularFieldTab> allList = mapper.selectAllFields(modularTab);
    	for(ModularFieldTab mft : allList){
    		String key = mft.getColumnName();
    		String label = mft.getColumnComment();
    		Map<String,String> entity = new HashMap<String,String>();
    		entity.put("key", key);
    		entity.put("label", label);
    		data.add(entity);
    	}
    	//通过模块ID查询所有模块字段信息
    	ModularFieldTabExample modularFieldTabExample = new ModularFieldTabExample();
    	modularFieldTabExample.createCriteria()
    	.andModularIdEqualTo(modularTab.getId());
    	List<ModularFieldTab> modularFieldList = modularFieldTabMapper.selectByExample(modularFieldTabExample);
    	for(ModularFieldTab mft : modularFieldList){
    		String key = mft.getColumnName();
    		value.add(key);
    	}
    	map.put("data", data);
		map.put("value", value);
		return map;
	}

	@Override
	public void saveFieldInfo(Long id, List<BaseOption> list) {
		//通过模块id删除模块字段信息
		ModularFieldTabExample modularFieldTabExample = new ModularFieldTabExample();
    	modularFieldTabExample.createCriteria()
    	.andModularIdEqualTo(id);
		modularFieldTabMapper.deleteByExample(modularFieldTabExample);
		//通过传来的list信息 录入模块字段信息
		for(BaseOption base : list){
			String columnName = base.getKey();
			String columnComment = base.getLabel();
			ModularFieldTab modularFieldTab = new ModularFieldTab();
			modularFieldTab.setModularId(id);
			modularFieldTab.setColumnName(columnName);
			modularFieldTab.setColumnComment(columnComment);
			modularFieldTab.setProp(StringUtil.underlineToCamel(columnName));
			modularFieldTab.setLabel(columnComment);
			modularFieldTabMapper.insert(modularFieldTab);
		}
	}

	@Override
	public Map<String, List> getQueryCriteriasById(Long id) {
		Map<String, List> map = new HashMap<String, List>();
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		List<String> value = new ArrayList<String>();
		//通过模块ID查询所有模块字段信息
    	ModularFieldTabExample modularFieldTabExample = new ModularFieldTabExample();
    	modularFieldTabExample.createCriteria()
    	.andModularIdEqualTo(id);
    	List<ModularFieldTab> modularFieldList = modularFieldTabMapper.selectByExample(modularFieldTabExample);
    	for(ModularFieldTab mft : modularFieldList){
    		String key = String.valueOf(mft.getId());
    		String label = mft.getProp()+"_"+mft.getLabel();
    		Map<String,String> entity = new HashMap<String,String>();
    		entity.put("key", key);
    		entity.put("label", label);
    		data.add(entity);
    	}
    	//通过模块ID查询 查询条件信息
    	QueryCriteriaItemTabExample queryCriteriaItemTabExample = new QueryCriteriaItemTabExample();
    	queryCriteriaItemTabExample.createCriteria()
    	.andModularIdEqualTo(id);
    	List<QueryCriteriaItemTab> queryCriteriaItemTabList = queryCriteriaItemTabMapper.selectByExample(queryCriteriaItemTabExample);
    	for(QueryCriteriaItemTab mft : queryCriteriaItemTabList){
    		String key = String.valueOf(mft.getFieldId());
    		value.add(key);
    	}
    	map.put("data", data);
		map.put("value", value);
		return map;
	}

	@Override
	public void saveQueryCriteriaInfo(Long id, List<BaseOption> list) {
		//通过模块id删除查询条件信息
		QueryCriteriaItemTabExample queryCriteriaItemTabExample = new QueryCriteriaItemTabExample();
		queryCriteriaItemTabExample.createCriteria()
    	.andModularIdEqualTo(id);
		List<QueryCriteriaItemTab> queryList = queryCriteriaItemTabMapper.selectByExample(queryCriteriaItemTabExample);
		for(QueryCriteriaItemTab query : queryList){
			Long queryCriteriaItemId = query.getId();
			ElementTabExample elementTabExample = new ElementTabExample();
			elementTabExample.createCriteria()
	    	.andQueryCriteriaItemIdEqualTo(queryCriteriaItemId);
			elementTabMapper.deleteByExample(elementTabExample);
		}
		queryCriteriaItemTabMapper.deleteByExample(queryCriteriaItemTabExample);
		//通过传来的list信息 录入查询条件信息
		for(BaseOption base : list){
			Long fieldId = Long.parseLong(base.getKey());
			String propAndLabel = base.getLabel();
			String prop = "";
			String label = "";
			if(propAndLabel.indexOf("_")>0){
				prop = propAndLabel.split("_")[0];
				label = propAndLabel.split("_")[1];
			}
			prop = StringUtil.firstCharToCamel(prop);
			QueryCriteriaItemTab queryCriteriaItemTab = new QueryCriteriaItemTab();
			queryCriteriaItemTab.setModularId(id);
			queryCriteriaItemTab.setFieldId(fieldId);
			//默认是和连接符
			queryCriteriaItemTab.setConnectorName("and");
			//默认是模糊匹配
			queryCriteriaItemTab.setComparisonRule("Like");
			//默认是4代表字符类型
			queryCriteriaItemTab.setDataType(4);
			queryCriteriaItemTab.setProp(
					queryCriteriaItemTab.getConnectorName() + 
					prop + 
					queryCriteriaItemTab.getComparisonRule());
			queryCriteriaItemTab.setLabel(label);
			queryCriteriaItemTabMapper.insert(queryCriteriaItemTab);
			ElementTab elementTab = new ElementTab();
			elementTab.setQueryCriteriaItemId(queryCriteriaItemTab.getId());
			//默认是文本输入框
			elementTab.setElementType("FormInput");
			elementTab.setElementTypeName("文本输入框");
			elementTab.setStyleName("width: 200px");
			elementTab.setModelName(queryCriteriaItemTab.getProp());
			elementTab.setPlaceholder(queryCriteriaItemTab.getLabel());
			elementTabMapper.insert(elementTab);
		}
	}

	@Override
	public Map<String, List> getTableItemsById(Long id) {
		Map<String, List> map = new HashMap<String, List>();
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		List<String> value = new ArrayList<String>();
		//通过模块ID查询所有模块字段信息
    	ModularFieldTabExample modularFieldTabExample = new ModularFieldTabExample();
    	modularFieldTabExample.createCriteria()
    	.andModularIdEqualTo(id);
    	List<ModularFieldTab> modularFieldList = modularFieldTabMapper.selectByExample(modularFieldTabExample);
    	for(ModularFieldTab mft : modularFieldList){
    		String key = String.valueOf(mft.getId());
    		String label = mft.getProp()+"_"+mft.getLabel();
    		Map<String,String> entity = new HashMap<String,String>();
    		entity.put("key", key);
    		entity.put("label", label);
    		data.add(entity);
    	}
    	//通过模块ID查询 表格项信息
    	TableItemTabExample tableItemTabExample = new TableItemTabExample();
    	tableItemTabExample.createCriteria()
    	.andModularIdEqualTo(id);
    	List<TableItemTab> tableItemTabList = tableItemTabMapper.selectByExample(tableItemTabExample);
    	for(TableItemTab mft : tableItemTabList){
    		String key = String.valueOf(mft.getFieldId());
    		value.add(key);
    	}
    	map.put("data", data);
		map.put("value", value);
		return map;
	}

	@Override
	public void saveTableItemInfo(Long id, List<BaseOption> list) {
		//通过模块id删除表格项信息
    	TableItemTabExample tableItemTabExample = new TableItemTabExample();
    	tableItemTabExample.createCriteria()
    	.andModularIdEqualTo(id);
    	tableItemTabMapper.deleteByExample(tableItemTabExample);
		//通过传来的list信息 录入表格项信息
		for(BaseOption base : list){
			Long fieldId = Long.parseLong(base.getKey());
			String propAndLabel = base.getLabel();
			String prop = "";
			String label = "";
			if(propAndLabel.indexOf("_")>0){
				prop = propAndLabel.split("_")[0];
				label = propAndLabel.split("_")[1];
			}
			TableItemTab tableItemTab = new TableItemTab();
			tableItemTab.setModularId(id);
			tableItemTab.setFieldId(fieldId);
			tableItemTab.setProp(prop);
			tableItemTab.setLabel(label);
			tableItemTab.setSortable("true");
			tableItemTab.setMinWidth("150px");
			tableItemTabMapper.insert(tableItemTab);
		}
	}

	@Override
	public Map<String, List> getFormItemsById(Long id) {
		Map<String, List> map = new HashMap<String, List>();
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		List<String> value = new ArrayList<String>();
		//通过模块ID查询所有模块字段信息
    	ModularFieldTabExample modularFieldTabExample = new ModularFieldTabExample();
    	modularFieldTabExample.createCriteria()
    	.andModularIdEqualTo(id);
    	List<ModularFieldTab> modularFieldList = modularFieldTabMapper.selectByExample(modularFieldTabExample);
    	for(ModularFieldTab mft : modularFieldList){
    		String key = String.valueOf(mft.getId());
    		String label = mft.getProp()+"_"+mft.getLabel();
    		Map<String,String> entity = new HashMap<String,String>();
    		entity.put("key", key);
    		entity.put("label", label);
    		data.add(entity);
    	}
    	//通过模块ID查询 表单项信息
    	FormItemTabExample formItemTabExample = new FormItemTabExample();
    	formItemTabExample.createCriteria()
    	.andModularIdEqualTo(id);
    	List<FormItemTab> formItemTabList = formItemTabMapper.selectByExample(formItemTabExample);
    	for(FormItemTab mft : formItemTabList){
    		String key = String.valueOf(mft.getFieldId());
    		value.add(key);
    	}
    	map.put("data", data);
		map.put("value", value);
		return map;
	}

	@Override
	public void saveFormItemInfo(Long id, List<BaseOption> list) {
		//通过模块id删除表单项信息
		FormItemTabExample formItemTabExample = new FormItemTabExample();
		formItemTabExample.createCriteria()
    	.andModularIdEqualTo(id);
		List<FormItemTab> queryList = formItemTabMapper.selectByExample(formItemTabExample);
		for(FormItemTab query : queryList){
			Long formItemId = query.getId();
			ElementTabExample elementTabExample = new ElementTabExample();
			elementTabExample.createCriteria()
	    	.andFormItemIdEqualTo(formItemId);
			elementTabMapper.deleteByExample(elementTabExample);
			RulesTabExample rulesTabExample = new RulesTabExample();
			rulesTabExample.createCriteria()
	    	.andFormItemIdEqualTo(formItemId);
			rulesTabMapper.deleteByExample(rulesTabExample);
		}
    	formItemTabMapper.deleteByExample(formItemTabExample);
		//通过传来的list信息 录入表单项信息
		for(BaseOption base : list){
			Long fieldId = Long.parseLong(base.getKey());
			String propAndLabel = base.getLabel();
			String prop = "";
			String label = "";
			if(!StringUtils.isEmpty(propAndLabel) && propAndLabel.indexOf("_")>0){
				prop = propAndLabel.split("_")[0];
				label = propAndLabel.split("_")[1];
			}
			FormItemTab formItemTab = new FormItemTab();
			formItemTab.setModularId(id);
			formItemTab.setFieldId(fieldId);
			formItemTab.setProp(prop);
			formItemTab.setLabel(label);
			formItemTabMapper.insert(formItemTab);
			ElementTab elementTab = new ElementTab();
			elementTab.setFormItemId(formItemTab.getId());
			//默认是文本输入框
			elementTab.setElementType("FormInput");
			elementTab.setElementTypeName("文本输入框");
			elementTab.setStyleName("width: 200px");
			elementTab.setModelName(formItemTab.getProp());
			elementTab.setPlaceholder("输入"+formItemTab.getLabel());
			elementTabMapper.insert(elementTab);
			RulesTab rulesTab = new RulesTab();
			rulesTab.setFormItemId(formItemTab.getId());
			//默认是必填
			rulesTab.setRulesType("requiredType");
			rulesTab.setRulesTypeName("必填验证");
			rulesTab.setRequired("true");
			rulesTab.setMessage("请输入"+formItemTab.getLabel());
			//默认触发方式为失去焦点事件
			rulesTab.setTriggerName("blur");
			rulesTabMapper.insert(rulesTab);
		}
	}

	@Override
	public String getModularInfo(String modularName) {
		Map<String,Object> map = new HashMap<>();
		ModularTabExample modularTabExample = new ModularTabExample();
    	modularTabExample.createCriteria()
    	.andNamespaceEqualTo(modularName);
    	List<ModularTab> modularList = mapper.selectByExample(modularTabExample);
    	if(modularList != null && modularList.size() > 0){
    		ModularTab modularTab = modularList.get(0);
    		String cnName = modularTab.getName();
    		if(!StringUtils.isEmpty(cnName)){
    			if(cnName.indexOf("_")>0){
    				cnName = cnName.split("_")[0];
    			}
    		}
    		//模块名称
    		map.put("cnName", cnName);
    		String name = modularTab.getNamespace();
    		Long modularId = modularTab.getId();
    		//模块对应的命名空间
    		map.put("name", name);
    		//模块表格项列表
    		List<Map<String,Object>> modularTableItemArr = new ArrayList<>();
    		//通过模块ID查询 表格项信息
        	TableItemTabExample tableItemTabExample = new TableItemTabExample();
        	tableItemTabExample.createCriteria()
        	.andModularIdEqualTo(modularId);
        	List<TableItemTab> tableItemTabList = tableItemTabMapper.selectByExample(tableItemTabExample);
        	for(TableItemTab mft : tableItemTabList){
        		Map<String,Object> itemMap = new HashMap<>();
        		itemMap.put("prop", mft.getProp());
        		itemMap.put("label", mft.getLabel());
        		itemMap.put("sortable", Boolean.valueOf(mft.getSortable()));
        		itemMap.put("minWidth", mft.getMinWidth());
        		modularTableItemArr.add(itemMap);
        	}
    		map.put("modularTableItemArr", modularTableItemArr);
    		//模块表单项对象
    		Map<String,Object> modularFormItemObj = new HashMap<>();
    		//表单项验证规则对象
    		Map<String,List<Map<String,Object>>> rules = new HashMap<>();
    		//表单项列表
    		List<Map<String,Object>> formItemArr = new ArrayList<>();
    		//通过模块ID查询 表单项信息
        	FormItemTabExample formItemTabExample = new FormItemTabExample();
        	formItemTabExample.createCriteria()
        	.andModularIdEqualTo(modularId);
        	List<FormItemTab> formItemTabList = formItemTabMapper.selectByExample(formItemTabExample);
        	for(FormItemTab mft : formItemTabList){
        		Long formItemId = mft.getId();
        		String prop = mft.getProp();
        		String label = mft.getLabel();
        		Map<String,Object> formItemMap = new HashMap<>();
        		formItemMap.put("prop", prop);
        		formItemMap.put("label", label);
        		//通过表单项ID或查询条件项ID查询元素数据
        		this.getElementDataSourceMap(formItemId, null, formItemMap);
        		formItemArr.add(formItemMap);
        		List<Map<String,Object>> formItemRuleList = new ArrayList<>();
        		//通过表单项ID查询验证规则数据
        		this.getFormItemRuleList(formItemId, formItemRuleList);
        		rules.put(prop, formItemRuleList);
        	}
    		modularFormItemObj.put("rules", rules);
    		modularFormItemObj.put("formItemArr", formItemArr);
    		map.put("modularFormItemObj", modularFormItemObj);
    		//查询条件列表
    		List<Map<String,Object>> modularQueryCriteriaRowArr = new ArrayList<>();
    		//通过模块ID查询 查询条件信息
        	QueryCriteriaItemTabExample queryCriteriaItemTabExample = new QueryCriteriaItemTabExample();
        	queryCriteriaItemTabExample.createCriteria()
        	.andModularIdEqualTo(modularId);
        	List<QueryCriteriaItemTab> queryCriteriaItemTabList = queryCriteriaItemTabMapper.selectByExample(queryCriteriaItemTabExample);
        	int i=0;
        	int queryCriteriaItemIndex = 0;
        	Map<String,Object> queryCriteriaItemMap = null;
        	for(QueryCriteriaItemTab queryCriteriaItemTab : queryCriteriaItemTabList){
        		Long queryCriteriaItemId = queryCriteriaItemTab.getId();
        		String prop = queryCriteriaItemTab.getProp();
        		String label = queryCriteriaItemTab.getLabel();
        		if(i%3==0){
        			queryCriteriaItemMap = new HashMap<>();
        			queryCriteriaItemMap.put("queryCriteriaItemIndex", queryCriteriaItemIndex);
        			List<Map<String,Object>> queryCriteriaItemArr = new ArrayList<>();
        			Map<String,Object> formItemMap = new HashMap<>();
            		formItemMap.put("prop", prop);
            		formItemMap.put("label", label);
            		//通过表单项ID或查询条件项ID查询元素数据
            		this.getElementDataSourceMap(null, queryCriteriaItemId, formItemMap);
            		queryCriteriaItemArr.add(formItemMap);
        			queryCriteriaItemMap.put("queryCriteriaItemArr", queryCriteriaItemArr);
        			modularQueryCriteriaRowArr.add(queryCriteriaItemMap);
        			queryCriteriaItemIndex++;
        		} else {
        			if(queryCriteriaItemMap != null){
        				List<Map<String,Object>> queryCriteriaItemArr = (List<Map<String,Object>>)queryCriteriaItemMap.get("queryCriteriaItemArr");
        				Map<String,Object> formItemMap = new HashMap<>();
                		formItemMap.put("prop", prop);
                		formItemMap.put("label", label);
                		//通过表单项ID或查询条件项ID查询元素数据
                		this.getElementDataSourceMap(null, queryCriteriaItemId, formItemMap);
                		queryCriteriaItemArr.add(formItemMap);
                		queryCriteriaItemMap.put("queryCriteriaItemArr", queryCriteriaItemArr);
        			}
        		}
        		i++;
        	}
    		map.put("modularQueryCriteriaRowArr", modularQueryCriteriaRowArr);
    	}
    	return JSON.toJSONString(map);
	}
	
	/**
	 * 通过表单项ID或查询条件项ID查询元素数据
	 * @param formItemId            表单项ID
	 * @param queryCriteriaItemId   查询条件项ID
	 * @param formItemMap           最终MAP对象
	 */
	private void getElementDataSourceMap(Long formItemId, Long queryCriteriaItemId, Map<String,Object> formItemMap){
		//通过表单项ID查询元素数据
		ElementTabExample elementTabExample = new ElementTabExample();
		if(formItemId!=null){
			elementTabExample.createCriteria()
	    	.andFormItemIdEqualTo(formItemId);
		}
		if(queryCriteriaItemId!=null){
			elementTabExample.createCriteria()
			.andQueryCriteriaItemIdEqualTo(queryCriteriaItemId);
		}
		List<ElementTab> elementTabList = elementTabMapper.selectByExample(elementTabExample);
		if(elementTabList != null && elementTabList.size() > 0){
			ElementTab elementTab = elementTabList.get(0);
			String elementType = elementTab.getElementType();
			if("FormInput".equals(elementType)){
				//文本输入框
				formItemMap.put("formInputFlag", true);
				List<Map<String,Object>> formDataSource = new ArrayList<>();
				Map<String,Object> formDataMap = new HashMap<>();
				formDataMap.put("modelName", elementTab.getModelName());
				formDataMap.put("styleName", elementTab.getStyleName());
				formDataMap.put("placeholder", elementTab.getPlaceholder());
				formDataSource.add(formDataMap);
				formItemMap.put("formInputsDataSource", formDataSource);
			} else if("FormTextArea".equals(elementType)){
				//文本域
				formItemMap.put("formTextAreaFlag", true);
				List<Map<String,Object>> formDataSource = new ArrayList<>();
				Map<String,Object> formDataMap = new HashMap<>();
				formDataMap.put("modelName", elementTab.getModelName());
				formDataMap.put("styleName", elementTab.getStyleName());
				formDataMap.put("placeholder", elementTab.getPlaceholder());
				formDataSource.add(formDataMap);
				formItemMap.put("formTextAreasDataSource", formDataSource);
			} else if("FormSelector".equals(elementType)){
				//选择器
				formItemMap.put("formSelectorFlag", true);
				List<Map<String,Object>> formDataSource = new ArrayList<>();
				Map<String,Object> formDataMap = new HashMap<>();
				formDataMap.put("modelName", elementTab.getModelName());
				formDataMap.put("styleName", elementTab.getStyleName());
				formDataMap.put("placeholder", elementTab.getPlaceholder());
				formDataMap.put("multiple", Boolean.valueOf(elementTab.getMultiple()));
				formDataMap.put("filterable", Boolean.valueOf(elementTab.getFilterable()));
				String groupName = elementTab.getOptions();
				DictionariesTabExample dictionariesTabExample = new DictionariesTabExample();
				dictionariesTabExample.setOrderByClause("SORT_NUM ASC");
				dictionariesTabExample.createCriteria()
            	.andGroupNameEqualTo(groupName);
				List<DictionariesTab> dictionariesTabList = dictionariesTabMapper.selectByExample(dictionariesTabExample);
				List<Map<String,Object>> optionsList = new ArrayList<>();
				for(DictionariesTab dictionariesTab : dictionariesTabList){
					Map<String,Object> optionItemMap = new HashMap<>();
					optionItemMap.put("value", dictionariesTab.getKey());
					optionItemMap.put("label", dictionariesTab.getValue());
					optionsList.add(optionItemMap);
				}
				formDataMap.put("options", optionsList);
				formDataSource.add(formDataMap);
				formItemMap.put("formSelectorsDataSource", formDataSource);
			} else if("FormRadio".equals(elementType)){
				//单选框
				formItemMap.put("formRadioFlag", true);
				List<Map<String,Object>> formDataSource = new ArrayList<>();
				Map<String,Object> formDataMap = new HashMap<>();
				formDataMap.put("modelName", elementTab.getModelName());
				formDataMap.put("styleName", elementTab.getStyleName());
				String groupName = elementTab.getOptions();
				DictionariesTabExample dictionariesTabExample = new DictionariesTabExample();
				dictionariesTabExample.setOrderByClause("SORT_NUM ASC");
				dictionariesTabExample.createCriteria()
            	.andGroupNameEqualTo(groupName);
				List<DictionariesTab> dictionariesTabList = dictionariesTabMapper.selectByExample(dictionariesTabExample);
				List<Map<String,Object>> optionsList = new ArrayList<>();
				for(DictionariesTab dictionariesTab : dictionariesTabList){
					Map<String,Object> optionItemMap = new HashMap<>();
					optionItemMap.put("value", dictionariesTab.getKey());
					optionItemMap.put("label", dictionariesTab.getValue());
					optionsList.add(optionItemMap);
				}
				formDataMap.put("options", optionsList);
				formDataSource.add(formDataMap);
				formItemMap.put("formRadiosDataSource", formDataSource);
			} else if("FormCheckbox".equals(elementType)){
				//多选框
				formItemMap.put("formCheckboxFlag", true);
				List<Map<String,Object>> formDataSource = new ArrayList<>();
				Map<String,Object> formDataMap = new HashMap<>();
				formDataMap.put("modelName", elementTab.getModelName());
				formDataMap.put("styleName", elementTab.getStyleName());
				String groupName = elementTab.getOptions();
				DictionariesTabExample dictionariesTabExample = new DictionariesTabExample();
				dictionariesTabExample.setOrderByClause("SORT_NUM ASC");
				dictionariesTabExample.createCriteria()
            	.andGroupNameEqualTo(groupName);
				List<DictionariesTab> dictionariesTabList = dictionariesTabMapper.selectByExample(dictionariesTabExample);
				List<Map<String,Object>> optionsList = new ArrayList<>();
				for(DictionariesTab dictionariesTab : dictionariesTabList){
					Map<String,Object> optionItemMap = new HashMap<>();
					optionItemMap.put("value", dictionariesTab.getKey());
					optionItemMap.put("label", dictionariesTab.getValue());
					optionsList.add(optionItemMap);
				}
				formDataMap.put("options", optionsList);
				formDataSource.add(formDataMap);
				formItemMap.put("formCheckboxsDataSource", formDataSource);
			} else if("FormDatePicker".equals(elementType)){
				//日期选择器
				formItemMap.put("formDatePickerFlag", true);
				List<Map<String,Object>> formDataSource = new ArrayList<>();
				Map<String,Object> formDataMap = new HashMap<>();
				formDataMap.put("modelName", elementTab.getModelName());
				formDataMap.put("styleName", elementTab.getStyleName());
				formDataMap.put("placeholder", elementTab.getPlaceholder());
				formDataSource.add(formDataMap);
				formItemMap.put("formDatePickersDataSource", formDataSource);
			} else if("FormTimePicker".equals(elementType)){
				//时间选择器
				formItemMap.put("formTimePickerFlag", true);
				List<Map<String,Object>> formDataSource = new ArrayList<>();
				Map<String,Object> formDataMap = new HashMap<>();
				formDataMap.put("modelName", elementTab.getModelName());
				formDataMap.put("styleName", elementTab.getStyleName());
				formDataMap.put("placeholder", elementTab.getPlaceholder());
				formDataSource.add(formDataMap);
				formItemMap.put("formTimePickersDataSource", formDataSource);
			} else if("FormDateTimePicker".equals(elementType)){
				//日期时间选择器
				formItemMap.put("formDateTimePickerFlag", true);
				List<Map<String,Object>> formDataSource = new ArrayList<>();
				Map<String,Object> formDataMap = new HashMap<>();
				formDataMap.put("modelName", elementTab.getModelName());
				formDataMap.put("styleName", elementTab.getStyleName());
				formDataMap.put("placeholder", elementTab.getPlaceholder());
				formDataSource.add(formDataMap);
				formItemMap.put("formDateTimePickersDataSource", formDataSource);
			} else if("FormSwitch".equals(elementType)){
				//开关选择器
				formItemMap.put("formSwitchFlag", true);
				List<Map<String,Object>> formDataSource = new ArrayList<>();
				Map<String,Object> formDataMap = new HashMap<>();
				formDataMap.put("modelName", elementTab.getModelName());
				formDataMap.put("styleName", elementTab.getStyleName());
				formDataSource.add(formDataMap);
				formItemMap.put("formSwitchsDataSource", formDataSource);
			}
		}
	}
	
	/**
	 * 通过表单项ID查询验证规则数据
	 * @param formItemId            表单项ID
	 * @param formItemRuleList
	 */
	private void getFormItemRuleList(Long formItemId, List<Map<String,Object>> formItemRuleList){
		//通过表单项ID查询验证规则数据
		RulesTabExample rulesTabExample = new RulesTabExample();
		rulesTabExample.createCriteria()
    	.andFormItemIdEqualTo(formItemId);
		List<RulesTab> rulesTabList = rulesTabMapper.selectByExample(rulesTabExample);
		for(RulesTab rulesTab : rulesTabList){
			Map<String,Object> formItemRuleMap = new HashMap<>();
			String rulesType = rulesTab.getRulesType();
			if("requiredType".equals(rulesType)){
				//必填验证
				formItemRuleMap.put("required", Boolean.valueOf(rulesTab.getRequired()));
				formItemRuleMap.put("message", rulesTab.getMessage());
				String trigger = rulesTab.getTriggerName();
				if(!StringUtils.isEmpty(trigger)){
					if(trigger.indexOf(",")>0){
						String[] stringArray = trigger.split(",");
						List<String> stringList = Arrays.asList(stringArray);
						formItemRuleMap.put("trigger", stringList);
					} else {
						formItemRuleMap.put("trigger", trigger);
					}
				} else {
					formItemRuleMap.put("trigger", "blur");
				}
			} else if("lengthType".equals(rulesType)){
				//长度验证
				Integer min = rulesTab.getMin();
				Integer max = rulesTab.getMax();
				Integer len = rulesTab.getLen();
				if(min != null){
					formItemRuleMap.put("min", min);
				}
				if(max != null){
					formItemRuleMap.put("max", max);
				}
				if(len != null){
					formItemRuleMap.put("len", len);
				}
				formItemRuleMap.put("message", rulesTab.getMessage());
				String trigger = rulesTab.getTriggerName();
				if(!StringUtils.isEmpty(trigger)){
					if(trigger.indexOf(",")>0){
						String[] stringArray = trigger.split(",");
						List<String> stringList = Arrays.asList(stringArray);
						formItemRuleMap.put("trigger", stringList);
					} else {
						formItemRuleMap.put("trigger", trigger);
					}
				} else {
					formItemRuleMap.put("trigger", "blur");
				}
			} else if("formatType".equals(rulesType)){
				//格式验证
				formItemRuleMap.put("type", rulesTab.getTypeId());
				formItemRuleMap.put("message", rulesTab.getMessage());
				String trigger = rulesTab.getTriggerName();
				if(!StringUtils.isEmpty(trigger)){
					if(trigger.indexOf(",")>0){
						String[] stringArray = trigger.split(",");
						List<String> stringList = Arrays.asList(stringArray);
						formItemRuleMap.put("trigger", stringList);
					} else {
						formItemRuleMap.put("trigger", trigger);
					}
				} else {
					formItemRuleMap.put("trigger", "blur");
				}
			} else if("validatorType".equals(rulesType)){
				//自定义验证
				formItemRuleMap.put("validator", rulesTab.getValidator());
				formItemRuleMap.put("message", rulesTab.getMessage());
				String trigger = rulesTab.getTriggerName();
				if(!StringUtils.isEmpty(trigger)){
					if(trigger.indexOf(",")>0){
						String[] stringArray = trigger.split(",");
						List<String> stringList = Arrays.asList(stringArray);
						formItemRuleMap.put("trigger", stringList);
					} else {
						formItemRuleMap.put("trigger", trigger);
					}
				} else {
					formItemRuleMap.put("trigger", "blur");
				}
			}
			formItemRuleList.add(formItemRuleMap);
		}
	}
}