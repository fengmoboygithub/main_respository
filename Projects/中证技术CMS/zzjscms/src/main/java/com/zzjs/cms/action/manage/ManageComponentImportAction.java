package com.zzjs.cms.action.manage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzjs.cms.base.action.ManageBaseAction;
import com.zzjs.cms.entity.ComponentImportRela;
import com.zzjs.cms.exception.BaseException;
import com.zzjs.cms.json.EntityJson;
import com.zzjs.cms.util.CodeTempUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 组件引入管理action
 * @author yangyanchao
 *
 */
@Controller
@RequestMapping("/manage/componentImport")
public class ManageComponentImportAction extends ManageBaseAction {

	/**
	 * 新建组件引入关系
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
	public EntityJson<ComponentImportRela> add(ComponentImportRela componentImportRela,
			HttpServletRequest request, ModelMap modelMap){
		EntityJson<ComponentImportRela> json = new EntityJson<ComponentImportRela>();
		try {
			componentImportRelaService.insert(componentImportRela);
			json.setResult(true);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		}
	}
	
	/**
	 * 删除组件引入关系
	 * @throws BaseException 
	 */
	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public EntityJson<String> delete(
			@RequestParam(value = "id") long id) {
		EntityJson<String> json = new EntityJson<String>();
		try {
			componentImportRelaService.deleteByPrimaryKey(id);
			json.setResult(true);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} 
	}
	
	/**
	 * 引入组件排序 
	 */
	@ResponseBody
	@RequestMapping(value = "/sort.json", method = RequestMethod.POST)
	public EntityJson<String> sort(
			@RequestParam(value = "sortJson") String sortJson) {
		EntityJson<String> json = new EntityJson<String>();
		JSONArray array = JSONArray.fromObject(sortJson);
		try {
			for (int i = 0; i < array.size(); i++) {
				JSONObject fileinfoMediaRela = array.getJSONObject(i);
				String relaId = fileinfoMediaRela.get("relaId").toString();
				String sort = fileinfoMediaRela.get("sort").toString();
				ComponentImportRela t = new ComponentImportRela();
				t.setId(Long.parseLong(relaId));
				t.setSort(Integer.parseInt(sort));
					componentImportRelaService.updateByPrimaryKey(t);
			}
			json.setResult(true);
			return json;
		} catch (BaseException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		}
		
	}
	
	/**
	 * 查询该组件所有运行的React代码
	 */
	@ResponseBody
	@RequestMapping(value = "/allCode.json", method = RequestMethod.POST)
	public EntityJson<Map<String,String>> allCode(
			@RequestParam(value = "id") long componentId) {
		EntityJson<Map<String,String>> json = new EntityJson<Map<String,String>>();
		try {
			Map<String,String> map = new HashMap<String, String>();
			//记录组件id,防止组件id重复
			HashMap<String,String> exitsMap = new HashMap<String,String>();
			//查询该组件所有运行的React代码
			String allCode = componentImportRelaService.selectComponentAllCodeByComponentId(componentId, exitsMap);
			map.put("jsCode", allCode);
			map.put("htmlCode", CodeTempUtil.getHtmlTemplate("组件", null, null, null));
			json.setT(map);
			json.setResult(true);
			return json;
		} catch (BaseException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		}
		
	}
}
