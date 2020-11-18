package com.zzjs.cms.action.manage;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzjs.cms.base.action.ManageBaseAction;
import com.zzjs.cms.base.json.BaseJson;
import com.zzjs.cms.entity.ComponentInstanceTab;
import com.zzjs.cms.entity.DataJsonInstance;
import com.zzjs.cms.exception.BaseException;
import com.zzjs.cms.json.EntityJson;

/**
 * 组件实例管理action
 * @author yangyanchao
 *
 */
@Controller
@RequestMapping("/manage/componentInstance")
public class ManageComponentInstanceTabAction extends ManageBaseAction {
	/**
	 * 新建组件实例
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
	public EntityJson<ComponentInstanceTab> add(ComponentInstanceTab componentInstanceTab,
			HttpServletRequest request, ModelMap modelMap){
		EntityJson<ComponentInstanceTab> json = new EntityJson<ComponentInstanceTab>();
		try {
			//新增组件实例
			Map<String,Object> map = componentInstanceTabService.addInstance(componentInstanceTab);
			boolean result = (Boolean)map.get("result");
			json.setT(componentInstanceTab);
			if(result){
				json.setT((ComponentInstanceTab)map.get("entity"));
			} else {
				json.setMsg((String)map.get("msg"));
			}
			json.setResult(result);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		}
	}
	
	/**
	 * 查询详情json
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/query.json", method = RequestMethod.POST)
	public EntityJson<ComponentInstanceTab> query(
			@RequestParam(value = "id") long id,
			HttpServletRequest request, ModelMap modelMap){
		EntityJson<ComponentInstanceTab> json = new EntityJson<ComponentInstanceTab>();
		try {
			ComponentInstanceTab cit = new ComponentInstanceTab();
			cit.setId(id);
			ComponentInstanceTab componentInstanceTab = componentInstanceTabService.selectByPrimaryKey(cit);
			json.setT(componentInstanceTab);
			json.setResult(true);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		}
	}
	
	/**
	 * 通过选择模板，并修改实例代码
	 */
	@ResponseBody
	@RequestMapping(value = "/update.json", method = RequestMethod.POST)
	public BaseJson update(
			ComponentInstanceTab componentInstanceTab,
			HttpServletRequest request, ModelMap modelMap)  {
		EntityJson<ComponentInstanceTab> json = new EntityJson<ComponentInstanceTab>();
		try {
			componentInstanceTabService.updateByInfo(componentInstanceTab);
			json.setResult(true);
			json.setT(componentInstanceTab);
			return json;
		} catch (BaseException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} 
	}
	
	/**
	 * 将该组件实例设置为组件使用的模板
	 * @param componentInstanceTab
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/setupTemplate.json", method = RequestMethod.POST)
	public BaseJson setupTemplate(
			ComponentInstanceTab componentInstanceTab,
			HttpServletRequest request, ModelMap modelMap) throws BaseException {
		//通过组件实例的信息添加组件模板信息
		return componentInstanceTabService.addTemplateByInstance(componentInstanceTab);
	}
	
	/**
	 * 通过实例id和json配置英文名查询数据源实例
	 */
	@ResponseBody
	@RequestMapping(value = "/queryDataJsonInstance.json", method = RequestMethod.POST)
	public EntityJson<DataJsonInstance> queryDataJsonInstance(
			DataJsonInstance dataJsonInstance,
			HttpServletRequest request, ModelMap modelMap)
			throws BaseException {
		EntityJson<DataJsonInstance> json = new EntityJson<DataJsonInstance>();
		try {
			DataJsonInstance dji = dataJsonInstanceService.selectByPrimaryKey(dataJsonInstance);
			json.setT(dji);
			json.setResult(true);
			return json;
		} catch (BaseException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} 
	}
	
	/**
	 * 通过修改数据源实例，并生成 实例React代码
	 */
	@ResponseBody
	@RequestMapping(value = "/updateByDataJsonInstance.json", method = RequestMethod.POST)
	public BaseJson updateByDataJsonInstance(
			DataJsonInstance dataJsonInstance,
			HttpServletRequest request, ModelMap modelMap)
			throws BaseException {
		EntityJson<DataJsonInstance> json = new EntityJson<DataJsonInstance>();
		Long instanceId = dataJsonInstance.getInstanceId();
		try {
			componentInstanceTabService.updateByDataJsonInstance(dataJsonInstance);
			DataJsonInstance dataJsonInstance_1 = new DataJsonInstance();
			dataJsonInstance_1.setInstanceId(instanceId);
			json.setResult(true);
			json.setT(dataJsonInstance_1);
			return json;
		} catch (BaseException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} 
	}
	
	/**
	 * 删除组件实例
	 * @throws BaseException 
	 */
	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public EntityJson<String> deleteComponent(
			@RequestParam(value = "id", defaultValue = "-1") long id,
			@RequestParam(value = "ids",required=false) String ids) {
		EntityJson<String> json = new EntityJson<String>();
		try {
			componentInstanceTabService.deleteByPrimaryKey(id, ids);
			json.setResult(true);
			return json;
		} catch (BaseException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} 
	}
	
	/**
	 * 查询该组件所有运行的React代码和组件实例代码
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "/allCode.json", method = RequestMethod.POST)
	public EntityJson<Map<String,String>> allCode(
			@RequestParam(value = "id") long id) throws Exception {
		EntityJson<Map<String,String>> json = new EntityJson<Map<String,String>>();
		try {
			Map<String,Map<String,String>> allMap = componentInstanceTabService.selectOneCodeToMapByPageIdAndInstanceId(-1, id);
			Map<String,String> map = allMap.get("component_instance_"+id);
			json.setT(map);
			json.setResult(true);
			return json;
		} catch (BaseException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		}
		
	}
	
	/**
	 * 重新加载该组件实例iframe
	 * @throws Exception 
	 * @throws BaseException 
	 */
	@ResponseBody
	@RequestMapping(value = "/loadInstanceIframe.json", method = RequestMethod.POST)
	public EntityJson<Map<String,Map<String,String>>> loadInstanceIframe(
			@RequestParam(value = "pageId", defaultValue = "-1") long pageId,
			@RequestParam(value = "instanceId", defaultValue = "-1") long instanceId) throws Exception {
		EntityJson<Map<String,Map<String,String>>> json = new EntityJson<Map<String,Map<String,String>>>();
		try {
			Map<String,Map<String,String>> map = componentInstanceTabService.selectOneCodeToMapByPageIdAndInstanceId(pageId, instanceId);
			json.setResult(true);
			json.setT(map);
			return json;
		} catch (BaseException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} 
	}
}
