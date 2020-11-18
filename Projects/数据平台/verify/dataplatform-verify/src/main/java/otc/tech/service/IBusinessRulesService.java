package otc.tech.service;

import java.util.Map;

import otc.tech.base.service.IBaseService;
import otc.tech.model.BusinessRules;

public interface IBusinessRulesService extends IBaseService<BusinessRules>{
	/**
	 * 查询全部规则封装成map
	 */
	public Map<String, BusinessRules> findMap();
	public String checBusinessRulesUnique(BusinessRules rule);
}
