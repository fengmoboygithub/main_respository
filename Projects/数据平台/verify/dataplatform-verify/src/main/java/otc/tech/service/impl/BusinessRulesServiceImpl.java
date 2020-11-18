package otc.tech.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import otc.tech.base.service.impl.BaseServiceImpl;
import otc.tech.mapper.BusinessRulesMapper;
import otc.tech.model.BusinessRules;
import otc.tech.service.IBusinessRulesService;
import otc.tech.util.StringUtils;

@Service
public class BusinessRulesServiceImpl extends BaseServiceImpl<BusinessRules> implements IBusinessRulesService {

	@Autowired
	private BusinessRulesMapper businessRulesMapper;

	@Override
	public Map<String, BusinessRules> findMap() {
		Map<String, BusinessRules> map = new HashMap<String, BusinessRules>();
		List<BusinessRules> businessRules = this.selectAll();
		for (BusinessRules br : businessRules) {
			map.put(br.getrKey(), br);
		}
		return map;
	}

	@Override
	public String checBusinessRulesUnique(BusinessRules rule) {
		Integer configId = StringUtils.isNull(rule.getrId()) ? -1 : rule.getrId();
		rule.setrId(null);
		BusinessRules info = businessRulesMapper.selectOne(rule);
		if (StringUtils.isNotNull(info) && !info.getrId().toString().equals(configId.toString())) {
			return "1";
		}
		return "0";
	}
}
