package com.zzjs.cms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzjs.cms.base.json.BaseJson;
import com.zzjs.cms.base.service.BaseServiceImpl;
import com.zzjs.cms.constant.ConfigConstant;
import com.zzjs.cms.dao.ComponentInstanceTabDao;
import com.zzjs.cms.entity.ComponentInstanceTab;
import com.zzjs.cms.entity.ComponentTemplate;
import com.zzjs.cms.entity.DataJsonInstance;
import com.zzjs.cms.entity.DataJsonTemplate;
import com.zzjs.cms.entity.FileInfo;
import com.zzjs.cms.entity.vo.ComponentVo;
import com.zzjs.cms.entity.vo.FileinfoMediaRelaVo;
import com.zzjs.cms.entity.vo.FolderVo;
import com.zzjs.cms.entity.vo.MediaVo;
import com.zzjs.cms.entity.vo.SiteVo;
import com.zzjs.cms.exception.BaseException;
import com.zzjs.cms.exception.FileInfoNotFoundException;
import com.zzjs.cms.util.CodeTempUtil;
import com.zzjs.cms.util.SSUtils;

/**
 * 组件service
 * 
 * @author yangyanchao
 */
@Service
public class ComponentInstanceTabService extends BaseServiceImpl<ComponentInstanceTab>{
	@Autowired
	private ComponentInstanceTabDao componentInstanceTabDao;
	@Autowired
	private ComponentService componentService;
	@Autowired
	private ComponentImportRelaService componentImportRelaService;
	@Autowired
	private FileInfoService fileInfoService;
	@Autowired
	protected ComponentTemplateService componentTemplateService;
	@Autowired
	protected DataJsonTemplateService dataJsonTemplateService;
	@Autowired
	protected DataJsonInstanceService dataJsonInstanceService;
	@Autowired
	private MediaService attachmentService;
	@Autowired
	private FileinfoMediaService fileinfoMediaService;
	@Autowired
	private FolderService folderService;
	@Autowired
	private SiteService siteService;
	@Autowired
	private ConfigService configService;
	
	public ComponentInstanceTabDao getDao(){
		return componentInstanceTabDao;
	}
	/**
	 * 查询该组件实例下的所有React代码
	 */
	public String selectAllCodeById(long id, HashMap<String,String> exitsMap) throws BaseException{
		ComponentInstanceTab ct = getDao().selectByPrimaryKey(id);
		//递归获取组件代码
		String allCode = componentImportRelaService.selectComponentAllCodeByComponentId(ct.getComponentId(), exitsMap);
		//allCode = CodeTempUtil.getJsTemplate(ct.getComponentName()+"组件",allCode);
		//获取组件实例代码
		String bodyCode = ("\n" + ct.getHtmlCode());
		allCode += CodeTempUtil.getJsTemplate(ct.getComponentName()+"组件实例",bodyCode);
		return allCode;
	}
	
	/**
	 * 查询该页面所包含的组件实例及其下面的组件所有React代码
	 * @throws FileInfoNotFoundException 
	 */
	public Map<String,String> selectAllCodeByPageId(long pageId) throws BaseException, FileInfoNotFoundException{
		Map<String,String> map = new HashMap<String, String>();
		ComponentInstanceTab componentInstanceTab = new ComponentInstanceTab();
		componentInstanceTab.setFileId(pageId);
		FileInfo fileInfo = fileInfoService.getFileInfoById(pageId);
		long fileId = fileInfo.getFileId();
		long siteId = fileInfo.getSiteId();
		SiteVo siteVo = siteService.getSiteById(siteId);
		String siteEname = siteVo.getSiteEname();
		//服务模式
		String model = configService.getStringByKey(ConfigConstant.ZZJS_CMS_MODEL);
		//资源文件项目地址
		String sourceAddress = configService.getStringByKey(ConfigConstant.ZZJS_CMS_SOURCE_ADDRESS+model);
		String mediaFileCode = "";
		//通过站点ID得到目录列表
		List<FolderVo> folderList = folderService.getAllFolderList(siteId);
		for(FolderVo folder : folderList){
			if(folder.getFatherId()==0){
				sourceAddress += (siteEname + "/" + folder.getPathEname() + "/");
				break;
			}
		}
		//通过站点Id得到所有资源列表 打上是否属于该文件的标识
		List<MediaVo> mediaAll = attachmentService.getMediaListAllBySiteId(siteId, fileId);
		//通过文件ID得到资源列表
		List<FileinfoMediaRelaVo> mediaFileList = fileinfoMediaService.getFileinfoMediaListByFileId(fileId, mediaAll);
		for(FileinfoMediaRelaVo fileinfoMediaRelaVo : mediaFileList){
			MediaVo media = fileinfoMediaRelaVo.getMedia();
			String suffix = media.getSuffix();
			String hrefStr = sourceAddress+fileinfoMediaRelaVo.getPathEname();
			if("css".equals(suffix)){
				mediaFileCode += "<link href=\""+hrefStr+"\" rel=\"stylesheet\">\n";
			} else if("js".equals(suffix)){
				mediaFileCode += "<script type=\"text/javascript\" src=\""+hrefStr+"\"></script>\n";
			}
		}
		//查询该页面下所有组件实例
		List<ComponentInstanceTab> instanceList = getDao().selectByPrimaryKeys(componentInstanceTab);
		String allJsCode = "";
		if(instanceList != null && instanceList.size() > 0){
			//记录组件id,防止组件id重复
			HashMap<String,String> exitsMap = new HashMap<String,String>();
			for(ComponentInstanceTab cct :instanceList){
				allJsCode += "\n"; 
				allJsCode += this.selectAllCodeById(cct.getId(), exitsMap);
				allJsCode += "\n"; 
			}
			allJsCode = CodeTempUtil.getJsTemplate("页面",allJsCode);
		}
		String allHtmlCode = CodeTempUtil.getHtmlTemplate("页面", fileInfo.getSourceCode(),mediaFileCode,null);
		map.put("jsCode", SSUtils.encodeByMe(allJsCode));
		map.put("htmlCode", SSUtils.encodeByMe(allHtmlCode));
		return map;
	}
	
	/**
	 * 封装各个组件实例代码以及html代码和媒体资源文件
	 * @throws FileInfoNotFoundException 
	 * @throws Exception 
	 */
	public Map<String,Map<String,String>> selectAllCodeToMapByPageId(long pageId) throws BaseException, Exception{
		Map<String,Map<String,String>> map = new HashMap<String, Map<String,String>>();
		ComponentInstanceTab componentInstanceTab = new ComponentInstanceTab();
		componentInstanceTab.setFileId(pageId);
		FileInfo fileInfo = fileInfoService.getFileInfoById(pageId);
		long fileId = fileInfo.getFileId();
		long siteId = fileInfo.getSiteId();
		SiteVo siteVo = siteService.getSiteById(siteId);
		String siteEname = siteVo.getSiteEname();
		//服务模式
		String model = configService.getStringByKey(ConfigConstant.ZZJS_CMS_MODEL);
		//资源文件项目地址
		String sourceAddress = configService.getStringByKey(ConfigConstant.ZZJS_CMS_SOURCE_ADDRESS+model);
		String mediaFileCode = "";
		//通过站点ID得到目录列表
		List<FolderVo> folderList = folderService.getAllFolderList(siteId);
		for(FolderVo folder : folderList){
			if(folder.getFatherId()==0){
				sourceAddress += (siteEname + "/" + folder.getPathEname() + "/");
				break;
			}
		}
		//通过站点Id得到所有资源列表 打上是否属于该文件的标识
		List<MediaVo> mediaAll = attachmentService.getMediaListAllBySiteId(siteId, fileId);
		//通过文件ID得到资源列表
		List<FileinfoMediaRelaVo> mediaFileList = fileinfoMediaService.getFileinfoMediaListByFileId(fileId, mediaAll);
		for(FileinfoMediaRelaVo fileinfoMediaRelaVo : mediaFileList){
			MediaVo media = fileinfoMediaRelaVo.getMedia();
			String suffix = media.getSuffix();
			String hrefStr = sourceAddress+fileinfoMediaRelaVo.getPathEname();
			if("css".equals(suffix)){
				mediaFileCode += "<link href=\""+hrefStr+"\" rel=\"stylesheet\">\n";
			} else if("js".equals(suffix)){
				mediaFileCode += "<script type=\"text/javascript\" src=\""+hrefStr+"\"></script>\n";
			}
		}
		//查询该页面下所有组件实例
		List<ComponentInstanceTab> instanceList = getDao().selectByPrimaryKeys(componentInstanceTab);
		if(instanceList != null && instanceList.size() > 0){
			for(ComponentInstanceTab cct :instanceList){
				//记录组件id,防止组件id重复
				HashMap<String,String> exitsMap = new HashMap<String,String>();
				String htmlCode = "";
				htmlCode += "<div class=\"container\">\n";
				htmlCode += "	<div class=\"row\">\n";
				htmlCode += "		<div class=\"col-md-12\">\n";
				htmlCode += "			<div class=\"render\" id=\"component_instance_"+cct.getId()+"\"></div>\n";
				htmlCode += "		</div>\n";
				htmlCode += "	</div>\n";
				htmlCode += "</div>\n";
				String allJsCode = "";
				allJsCode += "\n"; 
				allJsCode += this.selectAllCodeById(cct.getId(), exitsMap);
				allJsCode += "\n"; 
				allJsCode = CodeTempUtil.getJsTemplate("页面",allJsCode);
				htmlCode = CodeTempUtil.getHtmlTemplate("组件实例"+cct.getId(), htmlCode, mediaFileCode, null);
				HashMap<String,String> codeMap = new HashMap<String,String>();
				codeMap.put("jsCode", SSUtils.encodeByMe(allJsCode));
				codeMap.put("htmlCode", SSUtils.encodeByMe(htmlCode));
				map.put("component_instance_"+cct.getId(), codeMap);
			}
		}
		return map;
	}
	/**
	 * 封装各个组件实例代码以及html代码和媒体资源文件
	 * @throws FileInfoNotFoundException 
	 * @throws Exception 
	 */
	public Map<String,Map<String,String>> selectOneCodeToMapByPageIdAndInstanceId(long pageId,long instanceId) throws BaseException, Exception{
		if(pageId==-1){
			ComponentInstanceTab ct = getDao().selectByPrimaryKey(instanceId);
			pageId = ct.getFileId();
		}
		Map<String,Map<String,String>> map = new HashMap<String, Map<String,String>>();
		ComponentInstanceTab componentInstanceTab = new ComponentInstanceTab();
		componentInstanceTab.setFileId(pageId);
		FileInfo fileInfo = fileInfoService.getFileInfoById(pageId);
		long fileId = fileInfo.getFileId();
		long siteId = fileInfo.getSiteId();
		SiteVo siteVo = siteService.getSiteById(siteId);
		String siteEname = siteVo.getSiteEname();
		//服务模式
		String model = configService.getStringByKey(ConfigConstant.ZZJS_CMS_MODEL);
		//资源文件项目地址
		String sourceAddress = configService.getStringByKey(ConfigConstant.ZZJS_CMS_SOURCE_ADDRESS+model);
		String mediaFileCode = "";
		//通过站点ID得到目录列表
		List<FolderVo> folderList = folderService.getAllFolderList(siteId);
		for(FolderVo folder : folderList){
			if(folder.getFatherId()==0){
				sourceAddress += (siteEname + "/" + folder.getPathEname() + "/");
				break;
			}
		}
		//通过站点Id得到所有资源列表 打上是否属于该文件的标识
		List<MediaVo> mediaAll = attachmentService.getMediaListAllBySiteId(siteId, fileId);
		//通过文件ID得到资源列表
		List<FileinfoMediaRelaVo> mediaFileList = fileinfoMediaService.getFileinfoMediaListByFileId(fileId, mediaAll);
		for(FileinfoMediaRelaVo fileinfoMediaRelaVo : mediaFileList){
			MediaVo media = fileinfoMediaRelaVo.getMedia();
			String suffix = media.getSuffix();
			String hrefStr = sourceAddress+fileinfoMediaRelaVo.getPathEname();
			if("css".equals(suffix)){
				mediaFileCode += "<link href=\""+hrefStr+"\" rel=\"stylesheet\">\n";
			} else if("js".equals(suffix)){
				mediaFileCode += "<script type=\"text/javascript\" src=\""+hrefStr+"\"></script>\n";
			}
		}
		//记录组件id,防止组件id重复
		HashMap<String,String> exitsMap = new HashMap<String,String>();
		String htmlCode = "";
		htmlCode += "<div class=\"container\">\n";
		htmlCode += "	<div class=\"row\">\n";
		htmlCode += "		<div class=\"col-md-12\">\n";
		htmlCode += "			<div class=\"render\" id=\"component_instance_"+instanceId+"\"></div>\n";
		htmlCode += "		</div>\n";
		htmlCode += "	</div>\n";
		htmlCode += "</div>\n";
		String allJsCode = "";
		allJsCode += "\n"; 
		allJsCode += this.selectAllCodeById(instanceId, exitsMap);
		allJsCode += "\n"; 
		allJsCode = CodeTempUtil.getJsTemplate("页面",allJsCode);
		htmlCode = CodeTempUtil.getHtmlTemplate("组件实例"+instanceId, htmlCode, mediaFileCode, null);
		HashMap<String,String> codeMap = new HashMap<String,String>();
		codeMap.put("jsCode", SSUtils.encodeByMe(allJsCode));
		codeMap.put("htmlCode", SSUtils.encodeByMe(htmlCode));
		map.put("component_instance_"+instanceId, codeMap);
		return map;
	}
	public void deleteByPrimaryKey(long id, String ids) throws BaseException {
		if(id!=-1 && (ids==null || ids.length() == 0)){
			this.deleteByPrimaryKey(id);
			DataJsonInstance dataJsonInstance = new DataJsonInstance();
			dataJsonInstance.setInstanceId(id);
			dataJsonInstanceService.deleteByEntity(dataJsonInstance);
		} else if(ids != null && ids.length() > 0){
			String[] idsArr = ids.split(",");
			for(String id1 : idsArr){
				Long idl = Long.parseLong(id1);
				this.deleteByPrimaryKey(idl);
				DataJsonInstance dataJsonInstance = new DataJsonInstance();
				dataJsonInstance.setInstanceId(idl);
				dataJsonInstanceService.deleteByEntity(dataJsonInstance);
			}
		}
		
	}
	/**
	 * 新增组件实例
	 * @param componentInstanceTab
	 * @return
	 */
	public Map<String, Object> addInstance(ComponentInstanceTab componentInstanceTab) throws BaseException {
		Map<String, Object> map = new HashMap<String, Object>();
		//组件ID
		Long componentId = componentInstanceTab.getComponentId();
		/**	
		 * 通过组件Id查询默认组件模板 若存在默认组件模板则新增组件实例，
		 * 否则返回失败信息 --该组件未设置默认模板信息，请到组件模板管理中设置信息
		 */
		ComponentTemplate ct = new ComponentTemplate();
		ct.setComponentId(componentId);
		List<ComponentTemplate> templateList = componentTemplateService.selectByPrimaryKeys(ct);
		if( templateList != null && templateList.size() > 0 ){
			//新增组件实例
			getDao().insert(componentInstanceTab);
			ComponentTemplate componentTemplate = templateList.get(0);
			//默认组件模板id
			Long templateId = componentTemplate.getId();
			componentInstanceTab.setTemplateId(templateId);
			//通过选择模板，并修改实例代码
			this.updateByInfo(componentInstanceTab);
			map.put("result", true);
			map.put("entity", componentInstanceTab);
			map.put("msg", "添加组件实例成功");
		} else {
			map.put("result", false);
			map.put("msg", "该组件未设置默认模板信息，请到组件模板管理中设置信息");
		}
		return map;
	}
	/**
	 * 通过选择模板，并修改实例代码
	 * @param componentInstanceTab
	 */
	public void updateByInfo(ComponentInstanceTab componentInstanceTab) throws BaseException {
		//组件实例ID
		Long instanceId = componentInstanceTab.getId();
		//组件ID
		Long componentId = componentInstanceTab.getComponentId();
		//通过组件实例ID删除数据源实例
		DataJsonInstance djid = new DataJsonInstance();
		djid.setInstanceId(instanceId);
		dataJsonInstanceService.deleteByEntity(djid);
		//组件模板id
		Long templateId = componentInstanceTab.getTemplateId();
		DataJsonTemplate djt = new DataJsonTemplate();
		djt.setTemplateId(templateId);
		//通过组件模板id 查询数据源模板数据
		List<DataJsonTemplate> djtList = dataJsonTemplateService.selectByPrimaryKeys(djt);
		for(DataJsonTemplate dataJsonTemplate : djtList){
			String dataJsonEnName = dataJsonTemplate.getDataJsonEnName();
			String dataJsonName = dataJsonTemplate.getDataJsonName();
			String dataJsonCode = dataJsonTemplate.getDataJsonCode();
			DataJsonInstance dji = new DataJsonInstance();
			dji.setInstanceId(instanceId);;
			dji.setDataJsonEnName(dataJsonEnName);
			dji.setDataJsonName(dataJsonName);
			dji.setDataJsonCode(dataJsonCode);
			//从模板数据源中复制到实例数据源里
			dataJsonInstanceService.insert(dji);
		}
		//通过实例id查询数据源实例 并生成实例React代码
		String htmlCode = this.getHtmlCodeByInstanceId(instanceId, componentId);
		componentInstanceTab.setHtmlCode(htmlCode);
		this.getDao().updateByPrimaryKey(componentInstanceTab);
	}
	
	/**
	 * 通过修改数据源实例，并生成 实例React代码
	 * @param dataJsonInstance 
	 * 	updaet ## set dataJsonCode={dataJsonCode}  where  dataJsonEnName and instanceId
	 */
	public void updateByDataJsonInstance(DataJsonInstance dataJsonInstance) throws BaseException {
		//组件实例ID
		Long instanceId = dataJsonInstance.getInstanceId();
		dataJsonInstance.setInstanceId(0);
		dataJsonInstance.setDataJsonEnName("");
		dataJsonInstanceService.updateByPrimaryKey(dataJsonInstance);
		ComponentInstanceTab componentInstanceTab = new ComponentInstanceTab();
		componentInstanceTab.setId(instanceId);
		//得到实例对象
		ComponentInstanceTab cit = this.getDao().selectByPrimaryKey(componentInstanceTab);
		Long componentId = cit.getComponentId();
		//通过实例id查询数据源实例 并生成实例React代码
		String htmlCode = this.getHtmlCodeByInstanceId(instanceId, componentId);
		componentInstanceTab.setHtmlCode(htmlCode);
		this.getDao().updateByPrimaryKey(componentInstanceTab);
	}
	
	/**
	 * 通过实例id查询数据源实例 并生成实例React代码
	 * @param instanceId
	 * @return
	 * @throws BaseException
	 */
	public String getHtmlCodeByInstanceId(Long instanceId, long componentId) throws BaseException {
		//得到组件
		ComponentVo cv = componentService.getComponentById(componentId);
		//组件标签名
		String className = cv.getClassName();
		DataJsonInstance dji = new DataJsonInstance();
		dji.setInstanceId(instanceId);
		List<DataJsonInstance> djiList = dataJsonInstanceService.selectByPrimaryKeys(dji);
		String htmlCode = "";
		String renderCode = "\nReactDOM.render( <"+className+" ";
		for(DataJsonInstance dataJsonInstance : djiList){
			String dataJsonEnName = dataJsonInstance.getDataJsonEnName();
			String dataJsonName = dataJsonInstance.getDataJsonName();
			String dataJsonCode = dataJsonInstance.getDataJsonCode();
			htmlCode += CodeTempUtil.getJsonTemplate("instance_"+instanceId+"_"+dataJsonEnName, dataJsonName, dataJsonCode);
			renderCode += (dataJsonEnName+"={"+"instance_"+instanceId+"_"+dataJsonEnName+"} ");
		}
		renderCode += " />\n, document.getElementById('component_instance_"+instanceId+"') );\n";
		htmlCode += renderCode;
		return htmlCode;
	}
	
	/**
	 * 通过组件实例的信息添加组件模板信息
	 * @param componentInstanceTab
	 * @return
	 */
	public BaseJson addTemplateByInstance(ComponentInstanceTab componentInstanceTab) {
		//模板名
		String templateName = componentInstanceTab.getTemplateName();
		//组件id
		long componentId = componentInstanceTab.getComponentId();
		//组件实例id
		long instanceId = componentInstanceTab.getId();
		BaseJson json = new BaseJson();
		try{
			ComponentTemplate ct = new ComponentTemplate();
			ct.setComponentId(componentId);
			ct.setTemplateName(templateName);
			ct.setIsDefault("0");
			componentTemplateService.insert(ct);
			//组件模板id
			long templateId = ct.getId();
			DataJsonInstance dji = new DataJsonInstance();
			dji.setInstanceId(instanceId);
			//通过组件实例id 查询数据源实例数据
			List<DataJsonInstance> djtList = dataJsonInstanceService.selectByPrimaryKeys(dji);
			if(djtList == null || djtList.size() == 0){
				json.setResult(false);
				json.setMsg("数据源实例数据为空");
			} else {
				for(DataJsonInstance dataJsonInstance : djtList){
					String dataJsonEnName = dataJsonInstance.getDataJsonEnName();
					String dataJsonName = dataJsonInstance.getDataJsonName();
					String dataJsonCode = dataJsonInstance.getDataJsonCode();
					DataJsonTemplate djt = new DataJsonTemplate();
					djt.setTemplateId(templateId);;
					djt.setDataJsonEnName(dataJsonEnName);
					djt.setDataJsonName(dataJsonName);
					djt.setDataJsonCode(dataJsonCode);
					//从实例数据源中复制到模板数据源里
					dataJsonTemplateService.insert(djt);
				}
				json.setResult(true);
				json.setMsg("设置模板成功");
			}
			
		}catch(BaseException e){
			json.setResult(false);
			json.setMsg("设置模板失败");
		}
		return json;
	}
}
