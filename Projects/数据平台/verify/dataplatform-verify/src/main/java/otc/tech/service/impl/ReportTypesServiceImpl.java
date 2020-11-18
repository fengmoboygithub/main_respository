package otc.tech.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import otc.tech.base.service.impl.BaseServiceImpl;
import otc.tech.mapper.ReportTypesMapper;
import otc.tech.model.ReportTypes;
import otc.tech.service.IReportTypesService;
import otc.tech.util.StringUtils;
@Service
public class ReportTypesServiceImpl extends BaseServiceImpl<ReportTypes> implements IReportTypesService {
	
	@Autowired
	private ReportTypesMapper reportTypesMapper;
	@Override
	public String checkReportUnique(ReportTypes report) {
		Integer configId = StringUtils.isNull(report.getTypeId()) ? -1 : report.getTypeId();
		report.setTypeId(null);
		 ReportTypes info = reportTypesMapper.selectOne(report);
	        if (StringUtils.isNotNull(info) && !info.getTypeId().toString().equals(configId.toString()))
	        {
	            return "1";
	        }
	        return "0";
	    }

}
