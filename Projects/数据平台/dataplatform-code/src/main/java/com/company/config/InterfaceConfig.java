package com.company.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.config.interfaceinfo.InterfaceParam;
import com.company.config.interfaceinfo.InterfaceParamInfo;

/**
 * 接口信息配置类
 * 
 * @author yangyanchao
 *
 */
@Configuration
public class InterfaceConfig {

	/**
	 * 场外衍生品-持续报告-主协议-->>接口编码
	 */
	@Value("${a1001.code}")
	private String a1001Code;
	/**
	 * 场外衍生品-持续报告-主协议-->>报告库调用接口类型
	 */
	@Value("${a1001.type}")
	private String a1001Type;
	/**
	 * 场外衍生品-持续报告-主协议-->>关联编码
	 */
	@Value("${a1001.rela}")
	private String a1001Rela;
	
	/**
	 * 场外衍生品-持续报告-补充协议-->>接口编码
	 */
	@Value("${a1002.code}")
	private String a1002Code;
	/**
	 * 场外衍生品-持续报告-补充协议-->>报告库调用接口类型
	 */
	@Value("${a1002.type}")
	private String a1002Type;
	/**
	 * 场外衍生品-持续报告-补充协议-->>关联编码
	 */
	@Value("${a1002.rela}")
	private String a1002Rela;

	/**
	 * 场外衍生品-持续报告-期权交易确认书-->>接口编码
	 */
	@Value("${a1003.code}")
	private String a1003Code;
	/**
	 * 场外衍生品-持续报告-期权交易确认书-->>报告库调用接口类型
	 */
	@Value("${a1003.type}")
	private String a1003Type;
	/**
	 * 场外衍生品-持续报告-期权交易确认书-->>关联编码
	 */
	@Value("${a1003.rela}")
	private String a1003Rela;

	/**
	 * 场外衍生品-持续报告-互换交易确认书-->>接口编码
	 */
	@Value("${a1004.code}")
	private String a1004Code;
	/**
	 * 场外衍生品-持续报告-互换交易确认书-->>报告库调用接口类型
	 */
	@Value("${a1004.type}")
	private String a1004Type;
	/**
	 * 场外衍生品-持续报告-互换交易确认书-->>关联编码
	 */
	@Value("${a1004.rela}")
	private String a1004Rela;

	/**
	 * 场外衍生品-持续报告-互换及期权终止-->>接口编码
	 */
	@Value("${a1005.code}")
	private String a1005Code;
	/**
	 * 场外衍生品-持续报告-互换及期权终止-->>报告库调用接口类型
	 */
	@Value("${a1005.type}")
	private String a1005Type;
	/**
	 * 场外衍生品-持续报告-互换及期权终止-->>关联编码
	 */
	@Value("${a1005.rela}")
	private String a1005Rela;

	/**
	 * 场外衍生品-持续报告-履约保障书-->>接口编码
	 */
	@Value("${a1006.code}")
	private String a1006Code;
	/**
	 * 场外衍生品-持续报告-履约保障书-->>报告库调用接口类型
	 */
	@Value("${a1006.type}")
	private String a1006Type;
	/**
	 * 场外衍生品-持续报告-履约保障书-->>关联编码
	 */
	@Value("${a1006.rela}")
	private String a1006Rela;

	/**
	 * 场外衍生品-重大事项报告-->>接口编码
	 */
	@Value("${a1007.code}")
	private String a1007Code;
	/**
	 * 场外衍生品-重大事项报告-->>报告库调用接口类型
	 */
	@Value("${a1007.type}")
	private String a1007Type;
	/**
	 * 场外衍生品-重大事项报告-->>关联编码
	 */
	@Value("${a1007.rela}")
	private String a1007Rela;

	/**
	 * 场外衍生品-其他事项报告-->>接口编码
	 */
	@Value("${a1008.code}")
	private String a1008Code;
	/**
	 * 场外衍生品-其他事项报告-->>报告库调用接口类型
	 */
	@Value("${a1008.type}")
	private String a1008Type;
	/**
	 * 场外衍生品-其他事项报告-->>关联编码
	 */
	@Value("${a1008.rela}")
	private String a1008Rela;

	/**
	 * 场外衍生品-定期报告SAC-->>接口编码
	 */
	@Value("${a1009.code}")
	private String a1009Code;
	/**
	 * 场外衍生品-定期报告SAC-->>报告库调用接口类型
	 */
	@Value("${a1009.type}")
	private String a1009Type;
	/**
	 * 场外衍生品-定期报告SAC-->>关联编码
	 */
	@Value("${a1009.rela}")
	private String a1009Rela;

	/**
	 * 场外衍生品-定期报告NAFMII-->>接口编码
	 */
	@Value("${a1010.code}")
	private String a1010Code;
	/**
	 * 场外衍生品-定期报告NAFMII-->>报告库调用接口类型
	 */
	@Value("${a1010.type}")
	private String a1010Type;
	/**
	 * 场外衍生品-定期报告NAFMII-->>关联编码
	 */
	@Value("${a1010.rela}")
	private String a1010Rela;

	/**
	 * 场外衍生品-场外衍生品-定期报告ISDA-->>接口编码
	 */
	@Value("${a1011.code}")
	private String a1011Code;
	/**
	 * 场外衍生品-场外衍生品-定期报告ISDA-->>报告库调用接口类型
	 */
	@Value("${a1011.type}")
	private String a1011Type;
	/**
	 * 场外衍生品-场外衍生品-定期报告ISDA-->>关联编码
	 */
	@Value("${a1011.rela}")
	private String a1011Rela;

	@Bean
	public InterfaceParamInfo interfaceParamInfo() {
		InterfaceParamInfo interfaceParamInfo = new InterfaceParamInfo();
		interfaceParamInfo.putItem("A1001", new InterfaceParam(a1001Code, a1001Type, a1001Rela));
		interfaceParamInfo.putItem("A1002", new InterfaceParam(a1002Code, a1002Type, a1002Rela));
		interfaceParamInfo.putItem("A1003", new InterfaceParam(a1003Code, a1003Type, a1003Rela));
		interfaceParamInfo.putItem("A1004", new InterfaceParam(a1004Code, a1004Type, a1004Rela));
		interfaceParamInfo.putItem("A1005", new InterfaceParam(a1005Code, a1005Type, a1005Rela));
		interfaceParamInfo.putItem("A1006", new InterfaceParam(a1006Code, a1006Type, a1006Rela));
		interfaceParamInfo.putItem("A1007", new InterfaceParam(a1007Code, a1007Type, a1007Rela));
		interfaceParamInfo.putItem("A1008", new InterfaceParam(a1008Code, a1008Type, a1008Rela));
		interfaceParamInfo.putItem("A1009", new InterfaceParam(a1009Code, a1009Type, a1009Rela));
		interfaceParamInfo.putItem("A1010", new InterfaceParam(a1010Code, a1010Type, a1010Rela));
		interfaceParamInfo.putItem("A1011", new InterfaceParam(a1011Code, a1011Type, a1011Rela));
		return interfaceParamInfo;
	}
}
