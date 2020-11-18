/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.action.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzjs.cms.base.action.ManageBaseAction;
import com.zzjs.cms.constant.MediaEntityConstant.Entity;
import com.zzjs.cms.entity.vo.MediaEntityRelaVo;
import com.zzjs.cms.exception.FileInfoNotFoundException;
import com.zzjs.cms.json.EntityJson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/manage/mediaEntity")
public class ManageMediaEntityRelaAction extends ManageBaseAction {

	/**
	 * 添加关系
	 * @param mediaId
	 * @param entityId
	 * @param entity
	 * @return
	 * @throws FileInfoNotFoundException
	 */
	@ResponseBody
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public EntityJson<String> add(
			@RequestParam(value = "mediaId") long mediaId,
			@RequestParam(value = "entityId") long entityId,
			@RequestParam(value = "entity") Entity entity)
			throws FileInfoNotFoundException {
		EntityJson<String> json = new EntityJson<String>();
		MediaEntityRelaVo mediaEntityRelaVo = mediaEntityRelaService.getMediaEntityByEntityIdAndMediaId(entityId, mediaId, entity);
		if (mediaEntityRelaVo == null) {
			mediaEntityRelaService.addMediaEntityRela(mediaId, entityId, entity);
			json.setResult(true);
		} else {
			json.setMsg("已拥有该资源文件，请重新添加！");
			json.setResult(false);
		}
		return json;
	}

	/**
	 * 移除关系
	 * @param mediaId
	 * @param entityId
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public EntityJson<String> delete(@RequestParam(value = "relaId") long relaId)
			 {
		EntityJson<String> json = new EntityJson<String>();
		mediaEntityRelaService.deleteMediaEntityRela(relaId);
		json.setResult(true);
		return json;
	}
	
	/**
	 * 文件排序
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/sort.json", method = RequestMethod.POST)
	public EntityJson<String> sort(
			@RequestParam(value = "sortJson") String sortJson) {
		EntityJson<String> json = new EntityJson<String>();
		JSONArray array = JSONArray.fromObject(sortJson);
		for (int i = 0; i < array.size(); i++) {
			JSONObject fileinfoMediaRela = array.getJSONObject(i);
			String relaId = fileinfoMediaRela.get("relaId").toString();
			String sort = fileinfoMediaRela.get("sort").toString();
			mediaEntityRelaService.updateSort(Long.parseLong(relaId),
					Integer.parseInt(sort));
		}
		json.setResult(true);
		return json;
	}

}
