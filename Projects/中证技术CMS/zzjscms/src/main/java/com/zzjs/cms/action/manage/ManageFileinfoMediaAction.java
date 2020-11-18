package com.zzjs.cms.action.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzjs.cms.base.action.ManageBaseAction;
import com.zzjs.cms.entity.vo.FileinfoMediaRelaVo;
import com.zzjs.cms.exception.FileInfoNotFoundException;
import com.zzjs.cms.json.EntityJson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/manage/fileinfoMedia")
public class ManageFileinfoMediaAction extends ManageBaseAction {

	@ResponseBody
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public EntityJson<String> add(
			@RequestParam(value = "mediaId") long mediaId,
			@RequestParam(value = "fileId") long fileId)
			throws FileInfoNotFoundException {
		EntityJson<String> json = new EntityJson<String>();
		FileinfoMediaRelaVo fileinfoMediaRelaVo = fileinfoMediaService.getFileinfoMediaByfileIdAndmediaId(fileId, mediaId);
		if (fileinfoMediaRelaVo == null) {
			fileinfoMediaService.addFileinfoMedia(fileId, mediaId);
			json.setResult(true);
		} else {
			json.setMsg("已拥有该资源文件，请重新添加！");
			json.setResult(false);
		}
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public EntityJson<String> delete(@RequestParam(value = "mediaId") long mediaId,
			@RequestParam(value = "fileId") long fileId)
			 {
		EntityJson<String> json = new EntityJson<String>();
		fileinfoMediaService.deleteFileinfoMedia(fileId, mediaId);
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
			String mediaId = fileinfoMediaRela.get("mediaId").toString();
			String fileId = fileinfoMediaRela.get("fileId").toString();
			String sort = fileinfoMediaRela.get("sort").toString();
			fileinfoMediaService.updateSort(Long.parseLong(mediaId),Long.parseLong(fileId),
					Integer.parseInt(sort));
		}
		json.setResult(true);
		return json;
	}
}
