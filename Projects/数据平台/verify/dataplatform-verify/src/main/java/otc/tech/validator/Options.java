package otc.tech.validator;


import java.util.List;

import com.alibaba.fastjson.JSONObject;

import otc.tech.model.ReportTypes;
import otc.tech.model.Template;
import otc.tech.storage.FormData;

public class Options {
	public FormData formData;
	public ReportTypes reportType;
	public JSONObject jsonObject;
	public List<Template> elements;
	// 是否进行业务校验，false|忽略、true|不忽略
	public Boolean ignoreBusinessVerify = false;
}