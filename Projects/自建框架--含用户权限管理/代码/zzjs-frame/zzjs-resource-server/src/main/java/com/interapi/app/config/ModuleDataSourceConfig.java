package com.interapi.app.config;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * mysql Module配置类
 */
@Configuration
@MapperScan(basePackages = "com.interapi.app.modular.dao",sqlSessionTemplateRef = "modularSqlSessionTemplate")
public class ModuleDataSourceConfig {

	/**
	 * 创建数据源
	 *@return DataSource
	 */
	@Bean(name = "modularDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.modular")
	public DataSource modularDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	/**
	 * 创建工厂
	 *@param dataSource
	 *@throws Exception
	 *@return SqlSessionFactory
	 */
	@Bean(name = "modularSqlSessionFactory")
	public SqlSessionFactory modularSqlSessionFactory(@Qualifier("modularDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/interapi/app/modular/mapper/*.xml"));
		return bean.getObject();
	}
	
	/**
	 * 创建事务
	 *@param dataSource
	 *@return DataSourceTransactionManager
	 */
	@Bean(name = "modularTransactionManager")
	public DataSourceTransactionManager modularTransactionManager(@Qualifier("modularDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	/**
	 * 创建模板
	 *@param sqlSessionFactory  
	 *@return SqlSessionTemplate
	 */
	@Bean(name = "modularSqlSessionTemplate")
	public SqlSessionTemplate modularSqlSessionTemplate(@Qualifier("modularSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
