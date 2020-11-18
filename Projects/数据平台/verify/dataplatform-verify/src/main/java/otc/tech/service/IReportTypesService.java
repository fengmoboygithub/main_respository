package otc.tech.service;



import otc.tech.base.service.IBaseService;
import otc.tech.model.ReportTypes;

public interface IReportTypesService extends IBaseService<ReportTypes>{
	public String checkReportUnique(ReportTypes report);

}
