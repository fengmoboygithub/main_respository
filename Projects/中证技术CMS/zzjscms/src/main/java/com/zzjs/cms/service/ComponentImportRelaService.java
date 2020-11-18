package com.zzjs.cms.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzjs.cms.base.service.BaseServiceImpl;
import com.zzjs.cms.dao.ComponentDao;
import com.zzjs.cms.dao.ComponentImportRelaDao;
import com.zzjs.cms.entity.ComponentImportRela;
import com.zzjs.cms.entity.vo.ComponentVo;
import com.zzjs.cms.exception.BaseException;
import com.zzjs.cms.util.CodeTempUtil;

/**
 * 组件service
 * 
 * @author yangyanchao
 */
@Service
public class ComponentImportRelaService extends BaseServiceImpl<ComponentImportRela>{
	@Autowired
	private ComponentImportRelaDao componentImportRelaDao;
	
	public ComponentImportRelaDao getDao(){
		return componentImportRelaDao;
	}
	@Autowired
	private ComponentDao componentDao;
	
	public String selectComponentAllCodeByComponentId(long componentId, HashMap<String,String> exitsMap) throws BaseException {
		String allResults = "";
		if(exitsMap == null){
			ComponentImportRela cir = new ComponentImportRela();
			cir.setComponentId(componentId);
			List<ComponentImportRela> list = getDao().selectByPrimaryKeys(cir);
			
			if(list != null && list.size() > 0){
				for(ComponentImportRela cr : list){
					allResults += this.selectComponentAllCodeByComponentId(cr.getImportId(), exitsMap);
				}
			}
			ComponentVo cv = componentDao.getComponentById(componentId);
			String bodyCode = ("\n" + cv.getHtmlCode());
			allResults += CodeTempUtil.getJsTemplate(cv.getClassName()+"--组件",bodyCode);
		} else {
			if(exitsMap.containsKey(componentId+"")){
				//map中已经记录这个组件id
			} else {
				//map中没有记录这个组件id
				ComponentImportRela cir = new ComponentImportRela();
				cir.setComponentId(componentId);
				List<ComponentImportRela> list = getDao().selectByPrimaryKeys(cir);
				
				if(list != null && list.size() > 0){
					for(ComponentImportRela cr : list){
						allResults += this.selectComponentAllCodeByComponentId(cr.getImportId(), exitsMap);
					}
				}
				ComponentVo cv = componentDao.getComponentById(componentId);
				String bodyCode = ("\n" + cv.getHtmlCode());
				allResults += CodeTempUtil.getJsTemplate(cv.getClassName()+"--组件",bodyCode);
				exitsMap.put(componentId+"", "true");
			}
		}
		return allResults;
	}
}
