package com.company.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.config.repair.RepairParam;

/**
 * 重新报送配置类
 * 
 * @author yangyanchao
 *
 */
@Configuration
public class RepairConfig {

	/**
	 * 重新报送标识
	 */
	@Value("${work.repair.flag}")
	private boolean flag;
	/**
	 * 重新报送接口编码
	 */
	@Value("${work.repair.interfaceCode}")
	private String interfaceCode;
	
	@Bean
	public RepairParam repairParam() {
		RepairParam repairParam = new RepairParam(flag, interfaceCode);
		return repairParam;
	}
}
