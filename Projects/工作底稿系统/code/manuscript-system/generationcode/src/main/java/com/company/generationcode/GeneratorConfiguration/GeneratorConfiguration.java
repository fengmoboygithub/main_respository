package com.company.generationcode.GeneratorConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自动生成代码类
 * @author yangyanchao
 *
 */
public class GeneratorConfiguration {
	
	public static Logger logger = LoggerFactory.getLogger(GeneratorConfiguration.class);
    
    /**
     * 通过generatorConfig.xml配置信息 反向生成代码
     * @throws Exception
     */
    public static void generatorConfigForGen(Map<String, String> paramMap) throws Exception {
    	//根据Map 生成属性配置文件
    	GeneratorConfiguration.genPropertiesFile(paramMap);
    	String dialect = paramMap.get("dialect");
    	List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        File configFile = new File(GeneratorConfiguration.class.getClassLoader().getResource("generatorConfig_"+dialect+".xml").getFile());
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
    /**
     * 根据Map 生成属性配置文件
     * @param paramMap
     * @throws Exception
     */
    public static void genPropertiesFile(Map<String, String> paramMap) throws Exception {
    	
    	File parentFile = new File(GeneratorConfiguration.class.getClassLoader().getResource("").getFile());
    	File propertiesFile = new File(parentFile, "init.properties");
    	Properties pps = new Properties();
    	InputStream in = new FileInputStream(propertiesFile);
    	//从输入流中读取属性列表（键和元素对） 
    	pps.load(in);
    	//调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。  
    	//强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
    	OutputStream out = new FileOutputStream(propertiesFile);
    	if(paramMap != null && paramMap.size() > 0){
    		for(Entry<String, String> entry : paramMap.entrySet()){
    			pps.setProperty(entry.getKey(), entry.getValue());
    		}
    	}
    	//以适合使用 load 方法加载到 Properties 表中的格式，  
    	//将此 Properties 表中的属性列表（键和元素对）写入输出流  
    	pps.store(out, "");
    	logger.info("恭喜init.properties生成成功~~，路径："+propertiesFile.getPath()+"");
    }
}
