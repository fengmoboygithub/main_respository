package otc.tech.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import otc.tech.model.ReportTypes;
import otc.tech.service.IBusinessRulesService;
import otc.tech.service.IReportTypesService;
import otc.tech.service.ITemplateService;
import otc.tech.validator.Options;
import otc.tech.validator.ReportValidator;

@RestController
@RequestMapping("/Validator")
public class ValidatorController {
	private static final Logger log_Validation = LoggerFactory.getLogger(ValidatorController.class);
	@Autowired
	private IReportTypesService reportTypesService;

	@Autowired
	private ReportValidator reportValidator;

//	@Autowired
//	private IBusinessRulesService businessRulesService;
//
//	@Autowired
//	private ITemplateService templateService;

//	private final static int msgCount = 20;//最大错误提示数

	@PostMapping("/Verification")
	@ResponseBody
	public Map<String, Object> Verification(@RequestBody String json) {
		long a = System.currentTimeMillis();
		log_Validation.info("接口[Verification" + a + "] start ...");
		Map<String, Object> params = new HashMap<String, Object>();
		// 封装成JSON对象
		try {
			
		
		JSONObject jsonData = JSONObject.parseObject(json);
		String bizId = (String) jsonData.get("bizId");
		
		log_Validation.info("接口[Verification" + a + "]   "+bizId+"入参：" + json);
		
		//long b = System.currentTimeMillis();
		// 解析入参
		String typeCodeInterface = jsonData.getString("type");// 对外参数
		if (jsonData.get("data") == null) {
			jsonData.put("data", new JSONObject());
		}
		// 获得报告类型/模块类型
		ReportTypes re = new ReportTypes();
		re.setTypeCodeInterface(typeCodeInterface);
		ReportTypes reportTypeObt = reportTypesService.selectOne(re);
		if (reportTypeObt == null) {
			throw new Exception("入参[type]报告类型未找到！");
		}
		String operationType = jsonData.getString("operationType");// 是否业务效验
		// String reportTypeCode=reportTypeObt.getTypeCode();//对内
		// String templateType=reportTypeObt.gettTemplateType();//模板类型
		// 数据校验
		Options options = new Options();
		options.reportType = reportTypeObt;
		options.jsonObject = jsonData;
		if ("1".equals(operationType)) {
			options.ignoreBusinessVerify = true;
		}
		Map<String, Object> resultMap = reportValidator.verify(options);
		if (resultMap.size() > 0 && resultMap.containsKey("error")) {
			//StringBuffer resultSf = new StringBuffer();
			JSONObject resultData = new JSONObject();
			//@SuppressWarnings("unchecked")
			//List<Map<String, Object>> resultList = (List<Map<String, Object>>) resultMap.get("error");
			//int count = 1;
			resultData.putAll(resultMap);
			//JSONArray array= JSONArray.parseArray(JSON.toJSONString(resultMap));
//			for (Map<String, Object> map : resultList) {
//				//String errorMsg = (String) map.get("msg");
//				String errorMsg = map.toString();
//				resultData.putAll(map);
//				if (count > msgCount) {
//					break;
//				}
//				count++;
//			}
			params.putAll(resultData);
			params.put("code", "-1");
		} else {
			params.put("msg", "操作成功");
			params.put("code", "0");
		}
		log_Validation.info("接口[Verification" + a + "]  "+bizId+"出参：" + params.toString());
		log_Validation.info("接口[Verification" + a + "] "+bizId+"共耗时：" + (System.currentTimeMillis() - a) / 1000 + "s.");
		return params;
		} catch (Exception e) {
			params.put("error", "报告校验错误");
			params.put("code", "-1");
			return params;
		}
	}
}
