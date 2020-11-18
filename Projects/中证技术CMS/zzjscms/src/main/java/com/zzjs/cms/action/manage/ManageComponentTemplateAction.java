package com.zzjs.cms.action.manage;



import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzjs.cms.base.action.ManageBaseAction;
import com.zzjs.cms.base.json.BaseJson;
import com.zzjs.cms.entity.Admin;
import com.zzjs.cms.entity.Component;
import com.zzjs.cms.entity.ComponentTemplate;
import com.zzjs.cms.entity.ComponentType;
import com.zzjs.cms.entity.DataJsonInstance;
import com.zzjs.cms.entity.DataJsonTemplate;
import com.zzjs.cms.entity.vo.ComponentVo;
import com.zzjs.cms.entity.vo.PageVo;
import com.zzjs.cms.exception.BaseException;
import com.zzjs.cms.json.EntityJson;
import com.zzjs.cms.json.PageJson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 组件模板管理action
 * @author yangyanchao
 *
 */
@Controller
@RequestMapping("/manage/componentTemplate")
public class ManageComponentTemplateAction extends ManageBaseAction {
	
	private static Logger log=Logger.getLogger(ManageComponentTemplateAction.class);
	/**
	 * 新建组件模板
	 * @param adminId
	 * @param componentName
	 * @param compTypeId
	 * @param htmlCode
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public EntityJson<ComponentTemplate> add(ComponentTemplate componentTemplate,
			HttpServletRequest request, ModelMap modelMap){
		EntityJson<ComponentTemplate> json = new EntityJson<ComponentTemplate>();
		try {
			//新增组件模板
			componentTemplateService.insert(componentTemplate);
			json.setT(componentTemplate);
			json.setResult(true);
			return json;
		} catch (BaseException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		}
	}
	
	/**
	 * 查询详情json
	 * @throws BaseException
	 */
	@ResponseBody
	@RequestMapping(value = "/query.json", method = RequestMethod.POST)
	public EntityJson<ComponentTemplate> query(
			ComponentTemplate componentTemplate,
			HttpServletRequest request, ModelMap modelMap){
		EntityJson<ComponentTemplate> json = new EntityJson<ComponentTemplate>();
		try {
			ComponentTemplate ct = componentTemplateService.selectByPrimaryKey(componentTemplate);
			json.setT(ct);
			json.setResult(true);
			return json;
		} catch (BaseException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		}
	}
	
	/**
	 * 编辑组件模板
	 * @throws BaseException
	 */
	@ResponseBody
	@RequestMapping(value = "/update.json", method = RequestMethod.POST)
	public EntityJson<ComponentTemplate> update(
			ComponentTemplate componentTemplate,
			HttpServletRequest request, ModelMap modelMap)
			throws BaseException {
		EntityJson<ComponentTemplate> json = new EntityJson<ComponentTemplate>();
		try {
			componentTemplateService.updateByPrimaryKey(componentTemplate);
			json.setT(componentTemplate);
			json.setResult(true);
			return json;
		} catch (BaseException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} 
	}
	
	/**
	 * 删除组件模板
	 * @throws BaseException 
	 */
	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public EntityJson<String> delete(ComponentTemplate componentTemplate) {
		EntityJson<String> json = new EntityJson<String>();
		try {
			componentTemplateService.deleteByEntity(componentTemplate);
			json.setResult(true);
			return json;
		} catch (BaseException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} 
	}
	
	/**
	 * 分页查询组件模板
	 * @throws BaseException 
	 */
	@ResponseBody
	@RequestMapping(value = "/paging.json", method = RequestMethod.POST)
	public PageJson<ComponentTemplate> paging(@RequestParam(value = "pageIndex") int pageIndex,
			@RequestParam(value = "pageSize") int pageSize,
			ComponentTemplate componentTemplate) {
		PageJson<ComponentTemplate> json = new PageJson<ComponentTemplate>();
		try {
			componentTemplate.setRows(pageSize);
			json = componentTemplateService.getAllListJsonPage(pageIndex, componentTemplate);
			json.setResult(true);
			return json;
		} catch (BaseException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} 
	}
	
	

	/**
	 * 
	 * 进入模版的list页面
	 * @throws BaseException 
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			@RequestParam(value = "templateName", required = false) String templateName,
			HttpServletRequest request, ModelMap modelMap) throws BaseException {
		
		
		ComponentTemplate queryObj=new ComponentTemplate();
		queryObj.setTemplateName(templateName);
		queryObj.setIsDelete("1");
		PageVo<ComponentTemplate> pageVo=componentTemplateService.getAllListPage(pageNum,queryObj);
		modelMap.put("templateName", templateName);
		modelMap.put("pageVo", pageVo);
		modelMap.put("p", pageNum);
		return "manage/componenttemplate/list";
	}
	
	
	/**
	 * 进入修改组件页面
	 * @throws Exception
	 */
	@RequestMapping(value = "/update.htm", method = RequestMethod.GET)
	public String update(
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			@RequestParam(value = "templateId", defaultValue = "1") long templateId,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ComponentTemplate queryObj=new ComponentTemplate();
		queryObj.setId(templateId);
		ComponentTemplate queryResult=componentTemplateService.selectByPrimaryKey(queryObj);
		if(queryResult != null){
			modelMap.put("templateId", queryResult.getId());
			modelMap.put("templateName", queryResult.getTemplateName());
			modelMap.put("isDefault", queryResult.getIsDefault());
			modelMap.put("componentId", queryResult.getComponentId());
			long componentId=queryResult.getComponentId();
			Component componentQueryResult=componentService.getComponentById(componentId);
			if(componentQueryResult != null){
				modelMap.put("componentName", componentQueryResult.getComponentName());
				modelMap.put("componentHtmlCode", componentQueryResult.getHtmlCode());
			}
			//模板数据源
			DataJsonTemplate model=new DataJsonTemplate();
			model.setTemplateId(queryResult.getId());
			model.setIsDelete("1");
			List<DataJsonTemplate> pageVo=dataJsonTemplateService.selectByPrimaryKeys(model);
			modelMap.put("pageVo", pageVo);
			modelMap.put("p", pageNum);
			
			//添加组件列表
			ComponentVo component=new ComponentVo();
			ComponentType componentType=new ComponentType();
			componentType.setCompTypeName("功能组件");
			component.setComponentType(componentType);
			List<ComponentVo>  componentList=componentService.getAllComponent(component);
			modelMap.put("componentList", componentList);
		}
		
		return "manage/componenttemplate/update";
	}
	
	/**
	 * 逻辑删除模板
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteLogical.json", method = RequestMethod.POST)
	public EntityJson<String> deleteLogical(@RequestParam(value = "id") long id) {
		EntityJson<String> json = new EntityJson<String>();
		try {
			int updateResult=componentTemplateService.deleteTemplateLogical(id);
			if(updateResult != 1){
				json.setResult(false);
			}else{
				json.setResult(true);
			}
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} 
	}
	
	
	/**
	 * 
	 * 进入模版的add页面
	 * @throws BaseException 
	 */
	@RequestMapping(value = "/add.htm", method = RequestMethod.GET)
	public String addHtml(
			HttpServletRequest request, ModelMap modelMap) throws BaseException {
		Admin admin = this.getAdmin(request);
		modelMap.put("adminId", admin.getAdminId());
		//添加组件列表
		ComponentVo component=new ComponentVo();
		ComponentType componentType=new ComponentType();
		componentType.setCompTypeName("功能组件");
		component.setComponentType(componentType);
		List<ComponentVo>  queryResult=componentService.getAllComponent(component);
		modelMap.put("componentList", queryResult);
		return "manage/componenttemplate/add";
	}
	
	
	/**
	 * 添加模板
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addTemplate.json", method = RequestMethod.POST)
	public EntityJson<String> addTemplate(HttpServletRequest request,@RequestBody String body) {
		EntityJson<String> json = new EntityJson<String>();
		try {
			JSONObject req=JSONObject.fromObject(body);
			String templateName=req.getString("templateName");
			long componentId=req.getLong("componentId");
			String isDefault=req.getString("isDefault");
			ComponentTemplate template=new ComponentTemplate();
			template.setTemplateName(templateName);
			template.setComponentId(componentId);
			template.setIsDefault(isDefault);
			template.setIsDelete("1");
			Admin admin = this.getAdmin(request);
			template.setCreateUser(admin.getAdminId());
			template.setCreateTime(new Date());
			template.setUpdateTime(new Date());
			Integer result=componentTemplateService.addTemplate(template);
			log.info("==================result="+result+"===id="+template.getId());
			
			//添加json数据源模板
			JSONArray templateDataArray=req.getJSONArray("templateDataArray");
			for(Object obj:templateDataArray){
				JSONObject templateData=(JSONObject)obj;
				DataJsonTemplate dataJsonTemplate=new DataJsonTemplate();
				dataJsonTemplate.setTemplateId(template.getId());
				dataJsonTemplate.setDataJsonEnName(templateData.getString("dataJsonEnName"));
				dataJsonTemplate.setDataJsonName(templateData.getString("dataJsonName"));
				dataJsonTemplate.setDataJsonCode(templateData.getString("htmlCode"));
				dataJsonTemplate.setCreateUser(admin.getAdminId());
				dataJsonTemplate.setCreateTime(new Date());
				dataJsonTemplate.setIsDelete("1");
				dataJsonTemplateService.addDataJsonTemplate(dataJsonTemplate);
			}
			
			json.setResult(true);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} 
	}
	
	@ResponseBody
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public String getData(){
		return "get";
	}
	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public String postData(){
		return "post";
	}
	
	
	
	/**
	 * 添加模板
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateTemplate.json", method = RequestMethod.POST)
	public EntityJson<String> updateTemplate(HttpServletRequest request,@RequestBody String body) {
		EntityJson<String> json = new EntityJson<String>();
		try {
			JSONObject req=JSONObject.fromObject(body);
			String templateName=req.getString("templateName");
			long componentId=req.getLong("componentId");
			long templateId=req.getLong("templateId");
			String isDefault=req.getString("isDefault");
			ComponentTemplate template=new ComponentTemplate();
			template.setTemplateName(templateName);
			template.setComponentId(componentId);
			template.setIsDefault(isDefault);
			Admin admin = this.getAdmin(request);
			template.setUpdateUser(admin.getAdminId());
			template.setUpdateTime(new Date());
			template.setId(templateId);
			componentTemplateService.updateByIdSelective(template);
			
			json.setResult(true);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} 
	}
	
	
	
	
	
	
	/**
	 * 添加模板数据源
	 */
	@ResponseBody
	@RequestMapping(value = "/addDataJson.json", method = RequestMethod.POST)
	public JSONObject addDataJson(
			DataJsonTemplate dataJsonTemplate,
			HttpServletRequest request, ModelMap modelMap)
			throws BaseException {
		JSONObject result=new JSONObject();
		try {
			dataJsonTemplate.setCreateTime(new Date());
			dataJsonTemplate.setUpdateTime(new Date());
			dataJsonTemplate.setIsDelete("1");
			Admin admin = this.getAdmin(request);
			dataJsonTemplate.setCreateUser(admin.getAdminId());
			dataJsonTemplateService.addDataJsonTemplate(dataJsonTemplate);
			result.put("result", true);
			result.put("dataJsonId", dataJsonTemplate.getId());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("result", false);
			return result;
		} 
	}
	
	
	
	/**
	 * 删除模板数据源
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteDataJson.json", method = RequestMethod.POST)
	public JSONObject deleteDataJson(@RequestParam(value = "id") long id,
			HttpServletRequest request, ModelMap modelMap)
			throws BaseException {
		JSONObject result=new JSONObject();
		try {
			DataJsonTemplate dataJsonTemplate=new DataJsonTemplate();
			dataJsonTemplate.setId(id);
			dataJsonTemplate.setUpdateTime(new Date());
			dataJsonTemplate.setIsDelete("0");
			Admin admin = this.getAdmin(request);
			dataJsonTemplate.setUpdateUser(admin.getAdminId());
			dataJsonTemplateService.updateByIdSelective(dataJsonTemplate);
			result.put("result", true);
			result.put("dataJsonId", dataJsonTemplate.getId());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("result", false);
			return result;
		} 
	}
	
	
	/**
	 * 删除模板数据源
	 */
	@ResponseBody
	@RequestMapping(value = "/updateDataJson.json", method = RequestMethod.POST)
	public JSONObject updateDataJson(DataJsonTemplate dataJsonTemplate,
			HttpServletRequest request, ModelMap modelMap)
			throws BaseException {
		JSONObject result=new JSONObject();
		try {
			dataJsonTemplate.setUpdateTime(new Date());
			Admin admin = this.getAdmin(request);
			dataJsonTemplate.setUpdateUser(admin.getAdminId());
			dataJsonTemplateService.updateByIdSelective(dataJsonTemplate);
			result.put("result", true);
			result.put("dataJsonId", dataJsonTemplate.getId());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("result", false);
			return result;
		} 
	}
	
	
}
