package com.interapi.app.generationcode.GeneratorConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class GeneratorConfiguration {

    public static void main(String[] args) throws Exception {
    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	paramMap.put("jdbcDriver", "com.mysql.jdbc.Driver");
    	paramMap.put("jdbcUrl", "jdbc:mysql://127.0.0.1:3306/bmp");    
    	paramMap.put("jdbcUserId", "root");
    	paramMap.put("jdbcPassword", "root");
    	paramMap.put("projectPath", "D:/work13/springboot-app");
    	paramMap.put("tableName", "component_instance_tab");
    	paramMap.put("domainObjectName", "ComponentInstanceTab");
    	GeneratorConfiguration.genFile(paramMap);
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        File configFile = new File(GeneratorConfiguration.class.getClassLoader().getResource("generatorConfig.xml").getFile());
        // = new File("D://test1/generatorConfig.xml"); 
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
    
    public static void genFile(Map<String, Object> paramMap) throws Exception {
        //创建一个合适的Configration对象
        freemarker.template.Configuration configuration = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23);
        File parentFile = new File(GeneratorConfiguration.class.getClassLoader().getResource("").getFile());
        configuration.setDirectoryForTemplateLoading(new File(parentFile, "templateGen"));
        configuration.setObjectWrapper(new DefaultObjectWrapper(freemarker.template.Configuration.VERSION_2_3_23));
        configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码
        //获取或创建一个模版。
        Template template = configuration.getTemplate("generatorConfig.vm");
        File generatorConfigFile = new File(parentFile, "generatorConfig.xml");
        Writer writer  = new OutputStreamWriter(new FileOutputStream(generatorConfigFile),"UTF-8");
        template.process(paramMap, writer);
        System.out.println("恭喜generatorConfig.xml生成成功~~，路径："+generatorConfigFile.getParent()+"");
    }
}
