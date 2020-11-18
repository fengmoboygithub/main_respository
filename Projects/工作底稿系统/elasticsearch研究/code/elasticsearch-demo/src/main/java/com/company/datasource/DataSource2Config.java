package com.company.datasource;

//@Configuration
//@MapperScan(basePackages = "com.company.two.**.dao", sqlSessionTemplateRef  = "twoSqlSessionTemplate")
public class DataSource2Config {
	
//	/**
//	 * 配置文件所放目录
//	 */
//	@Value("${spring.profiles.path}")
//	private String path;
//
//    @Bean(name = "twoDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.two")
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "twoSqlSessionFactory")
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("twoDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        //bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("file:"+path+"/mybatis/two/**/mapper/*.xml"));
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/com/company/two/**/mapper/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "twoTransactionManager")
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("twoDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "twoSqlSessionTemplate")
//    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("twoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }

}
