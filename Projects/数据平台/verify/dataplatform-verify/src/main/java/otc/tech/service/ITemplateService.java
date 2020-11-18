package otc.tech.service;

import java.util.List;

import otc.tech.base.service.IBaseService;
import otc.tech.model.Template;

public interface ITemplateService extends IBaseService<Template> {
	/**
	 * 获取指定模板所有要素，根据模板类型
	 * 
	 * @param templateType
	 * @return
	 */
	public List<Template> findAllByTemplateType(String templateType);

	/**
	 * 获取指定模板所有要素（包含Tuple父子及关系），根据模板类型
	 * 
	 * @param templateType
	 * @return
	 */
	public List<Template> findByTemplateType(String templateType);

	/**
	 * 获取模板普通要素（根据模板类型）
	 * 
	 * @param templateType
	 * @return
	 */
	//public List<Template> findRootElement(String templateType);

	/**
	 * 获取Tuple子元素
	 * 
	 * @param templateType
	 * @param tupleName
	 * @return
	 */
	public List<Template> findLeafElement(String templateType, String templateType2);
	
	public String checkTemplateUnique(Template Template);

}
