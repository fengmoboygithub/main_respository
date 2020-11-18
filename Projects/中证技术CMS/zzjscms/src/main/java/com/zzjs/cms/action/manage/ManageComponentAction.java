package com.zzjs.cms.action.manage;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzjs.cms.base.action.ManageBaseAction;
import com.zzjs.cms.entity.Admin;
import com.zzjs.cms.entity.Component;
import com.zzjs.cms.entity.ComponentImportRela;
import com.zzjs.cms.entity.ComponentType;
import com.zzjs.cms.entity.vo.ComponentTypeVo;
import com.zzjs.cms.entity.vo.ComponentVo;
import com.zzjs.cms.entity.vo.PageVo;
import com.zzjs.cms.json.EntityJson;
import com.zzjs.cms.json.ListJson;
import com.zzjs.cms.util.SSUtils;

/**
 * 组件管理action
 * @author yangyanchao
 *
 */
@Controller
@RequestMapping("/manage/component")
public class ManageComponentAction extends ManageBaseAction {

	/**
	 * 进入新建组件页面
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/add.htm", method = RequestMethod.GET)
	public String add(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {
		Admin admin = this.getAdmin(request);
		modelMap.put("adminId", admin.getAdminId());
		//查询组件类型列表
		List<ComponentType> componentTypes = componentService.getAllComponentType();
		modelMap.put("componentTypes", componentTypes);
		return "manage/component/add";
	}
	
	/**
	 * 新建组件
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
	public EntityJson<Component> add(
			@RequestParam("componentName") String componentName,
			@RequestParam("compTypeId") long compTypeId,
			@RequestParam("htmlCode") String htmlCode,
			@RequestParam("className") String className,
			@RequestParam("sort") int sort,
			HttpServletRequest request, ModelMap modelMap){
		EntityJson<Component> json = new EntityJson<Component>();
		try {
			Component component = componentService.addComponent(SSUtils.toText(componentName.trim()),
					compTypeId, htmlCode, className, sort);
			json.setT(component);
			json.setResult(true);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		}
	}
	
	/**
	 * 进入修改组件页面
	 * @throws Exception
	 */
	@RequestMapping(value = "/update.htm", method = RequestMethod.GET)
	public String update(
			@RequestParam(value = "componentId", defaultValue = "1") long componentId,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ComponentVo componentVo = componentService.getComponentById(componentId);
		//查询组件类型列表
		List<ComponentType> componentTypes = componentService.getAllComponentType();
		ComponentVo cVo = new ComponentVo();
		//查询所有组件列表
		List<ComponentVo> componentAll = componentService.getAllComponent(cVo);
		//查询该组件引入列表
		ComponentImportRela cir = new ComponentImportRela();
		cir.setComponentId(componentVo.getComponentId());
		List<ComponentImportRela> componentImportList = componentImportRelaService.selectByPrimaryKeys(cir);
		for(ComponentVo cv : componentAll){
			if(cv.getComponentId() == componentId){
				cv.setOwner("yes");
			} else {
				for(ComponentImportRela cr : componentImportList){
					if(cv.getComponentId() == cr.getImportId()){
						cv.setOwner("yes");
						break;
					}
				}
			}
		}
		modelMap.put("componentAll", componentAll);
		modelMap.put("componentImportList", componentImportList);
		modelMap.put("componentTypes", componentTypes);
		modelMap.put("componentVo", componentVo);
		modelMap.put("JSESSIONID", request.getSession().getId());
		return "manage/component/update";
	}
	
	/**
	 * 修改组件信息
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping(value = "/update.json", method = RequestMethod.POST)
	public EntityJson<Component> update(
			@RequestParam("componentId") long componentId,
			@RequestParam("compTypeId") long compTypeId,
			@RequestParam("componentName") String componentName,
			@RequestParam("sort") int sort,
			@RequestParam("className") String className,
			@RequestParam("htmlCode") String htmlCode,
			HttpServletRequest request, ModelMap modelMap)
			throws ParseException {
		EntityJson<Component> json = new EntityJson<Component>();
		try {
			Component Component = componentService.updateComponentById(componentId, compTypeId, SSUtils.toText(componentName.trim()), 
					sort, className, htmlCode);
			json.setT(Component);
			json.setResult(true);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} 
	}
	
	/**
	 * 删除组件
	 */
	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public EntityJson<String> deleteComponent(
			@RequestParam(value = "componentId") long componentId){
		EntityJson<String> json = new EntityJson<String>();
		componentService.deleteComponent(componentId);
		json.setResult(true);
		return json;
	}

	/**
	 * 进入组件列表分页的页面
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			@RequestParam(value = "componentName", required = false) String componentName,
			@RequestParam(value = "compTypeId", required = false) String compTypeId,
			HttpServletRequest request, ModelMap modelMap) {
//		Admin admin = this.getAdmin(request);
//		long adminId = admin.getAdminId();
		
		//查询组件类型列表
		List<ComponentType> componentTypes = componentService.getAllComponentType();
		modelMap.put("componentTypes", componentTypes);
		
		PageVo<ComponentVo> pageVo = componentService.getComponentListPage(pageNum,  componentName, compTypeId);
//		int initCount = componentService.getComponentListCount(componentName, compTypeId,ComponentConstant.CheckStatus.init);
//		int noCount = componentService.getComponentListCount(componentName, compTypeId,ComponentConstant.CheckStatus.no);
//		int allCount = initCount + noCount + 
//				componentService.getComponentListCount(componentName, compTypeId,ComponentConstant.CheckStatus.yes);;
		modelMap.put("pageVo", pageVo);
		modelMap.put("p", pageNum);
		modelMap.put("componentName", componentName);
		modelMap.put("compTypeId", compTypeId);
		
//		modelMap.put("initCount", initCount);
//		modelMap.put("noCount", noCount);
//		modelMap.put("allCount", allCount);
		return "manage/component/list";
	}
	
	/**
	 * 查询所有组件类型
	 * @param request
	 * @param httpServletResponse
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getAllComponentTypes.json", method = RequestMethod.GET)
	public String getAllComponentTypes(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		ListJson<ComponentTypeVo> componentTypes = new ListJson<ComponentTypeVo>();
		try {
			List<ComponentTypeVo> types = componentService.getAllDelPToHTMLComponentTypeVos();
			componentTypes.setList(types);
			componentTypes.setResult(true);
			componentTypes.setMsg("获取数据成功");
		} catch (Exception e) {
			e.printStackTrace();
			componentTypes.setResult(false);
			componentTypes.setMsg("获取数据失败");
		}
		return this.objToJson(componentTypes);
	}
	
}
