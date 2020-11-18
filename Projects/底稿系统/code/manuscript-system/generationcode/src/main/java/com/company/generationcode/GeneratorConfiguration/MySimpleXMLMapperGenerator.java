package com.company.generationcode.GeneratorConfiguration;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.XMLMapperGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.company.generationcode.bean.FileUrl;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;


public class MySimpleXMLMapperGenerator extends XMLMapperGenerator {
	public static Logger logger = LoggerFactory.getLogger(MySimpleXMLMapperGenerator.class);
    static FileUrl fileUrl;
    public static final String configDirPath = "M:/config/manuscript-system/";
    @Override
    protected XmlElement getSqlMapElement() {
    	FullyQualifiedTable table = introspectedTable.getFullyQualifiedTable();
        progressCallback.startTask(getString(
                "Progress.12", table.toString())); //$NON-NLS-1$
        XmlElement answer = new XmlElement("mapper"); //$NON-NLS-1$
        String entityPath = introspectedTable.getBaseRecordType();
        String entityName = introspectedTable.getTableConfiguration().getDomainObjectName();
        String packName = entityPath.replaceAll("\\.model\\."+entityName, "");
        String namespace = packName+".dao."+entityName+"Mapper";
        answer.addAttribute(new Attribute("namespace", //$NON-NLS-1$
                namespace));

        context.getCommentGenerator().addRootComment(answer);
        
        addResultMapWithoutBLOBsElement(answer);
        addResultMapWithBLOBsElement(answer);
        addExampleWhereClauseElement(answer);
        addMyBatis3UpdateByExampleWhereClauseElement(answer);
        addBaseColumnListElement(answer);
        addBlobColumnListElement(answer);
        addSelectByExampleWithBLOBsElement(answer);
        addSelectByExampleWithoutBLOBsElement(answer);
        addSelectByPrimaryKeyElement(answer);
        addDeleteByPrimaryKeyElement(answer);
        addDeleteByExampleElement(answer);
        addInsertElement(answer);
        addInsertSelectiveElement(answer);
        addCountByExampleElement(answer);
        addUpdateByExampleSelectiveElement(answer);
        addUpdateByExampleWithBLOBsElement(answer);
        addUpdateByExampleWithoutBLOBsElement(answer);
        addUpdateByPrimaryKeySelectiveElement(answer);
        addUpdateByPrimaryKeyWithBLOBsElement(answer);
        addUpdateByPrimaryKeyWithoutBLOBsElement(answer);
        fileUrl=new FileUrl();
        
        String targetProject = context.getSqlMapGeneratorConfiguration().getTargetProject();
        String primaryType = "";
        String primaryKey = "";
        List<IntrospectedColumn> keyList = introspectedTable.getPrimaryKeyColumns();
        if(keyList != null && keyList.size() > 0) {
        	primaryType = (introspectedTable.getPrimaryKeyColumns().get(0)).getFullyQualifiedJavaType().getShortName();
            primaryKey = (introspectedTable.getPrimaryKeyColumns().get(0)).getJavaProperty();
        }
        fileUrl.setExampleurl(introspectedTable.getExampleType());
        //fileUrl.setExampleurl(introspectedTable.getBaseRecordType()+"Example");
        fileUrl.setBeanurl(introspectedTable.getBaseRecordType());
        String beanName = packName.substring(0, packName.lastIndexOf("."));
        fileUrl.setPackName(packName);
        fileUrl.setBeanName(beanName);
        fileUrl.setControllerurl(packName+".controller");
        fileUrl.setDaourl(packName+".dao");
        fileUrl.setServiceImplurl(packName+".serviceImpl");
        fileUrl.setServiceurl(packName+".service");
        fileUrl.setTableName(introspectedTable.getTableConfiguration().getTableName());
        try {
//        	File parentFile = new File(GeneratorConfiguration.class.getClassLoader().getResource("").getFile());
        	File parentFile = new File(configDirPath);
        	File propertiesFile = new File(parentFile, "init.properties");
        	Properties pt = new Properties();
        	InputStream in = new FileInputStream(propertiesFile);
        	pt.load(in);
            fileUrl.setCnObjectName(pt.getProperty("cnObjectName"));
//            fileUrl.setMenuName(pt.getProperty("menuName"));
//            fileUrl.setPageSort(pt.getProperty("pageSort"));
//            fileUrl.setMenuSort(pt.getProperty("menuSort"));
            genDAO( introspectedTable.getTableConfiguration().getDomainObjectName(),primaryType,primaryKey,targetProject);
            genController( introspectedTable.getTableConfiguration().getDomainObjectName(),primaryType,primaryKey,targetProject);
            genService( introspectedTable.getTableConfiguration().getDomainObjectName(),primaryType,primaryKey,targetProject);
            genServiceImpl( introspectedTable.getTableConfiguration().getDomainObjectName(),primaryType,primaryKey,targetProject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;

    }

    public static void genController(String name ,String primaryType, String primaryKey, String basePath) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("controllerUrl", fileUrl.getControllerurl());
        paramMap.put("serviceUrl", fileUrl.getServiceurl());
        paramMap.put("url", fileUrl.getBeanurl());
        paramMap.put("exampleurl", fileUrl.getExampleurl());
        paramMap.put("name", name);
        paramMap.put("primaryType", primaryType);
        paramMap.put("primaryKey", primaryKey);
		if(primaryKey != null && primaryKey.length() > 0){
			String primaryKeyDa = "";
			primaryKeyDa = (primaryKey.charAt(0)+"").toUpperCase() + primaryKey.substring(1);
			paramMap.put("primaryKeyDa", primaryKeyDa);
		}
        paramMap.put("capitalName", name);
        paramMap.put("tableName", fileUrl.getTableName());
        paramMap.put("packName", fileUrl.getPackName());
        paramMap.put("beanName", fileUrl.getBeanName());
        paramMap.put("cnObjectName", fileUrl.getCnObjectName());
//        paramMap.put("menuName", fileUrl.getMenuName());
//        paramMap.put("pageSort", fileUrl.getPageSort());
//        paramMap.put("menuSort", fileUrl.getMenuSort());
        genFile(paramMap,fileUrl.getControllerurl(),"Controller","controller.vm", basePath);
    }
    public static void genService(String name ,String primaryType, String primaryKey, String basePath) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("serviceUrl", fileUrl.getServiceurl());
        paramMap.put("url", fileUrl.getBeanurl());
        paramMap.put("exampleurl", fileUrl.getExampleurl());
        paramMap.put("name", name);
        paramMap.put("primaryType", primaryType);
        paramMap.put("primaryKey", primaryKey);
        paramMap.put("tableName", fileUrl.getTableName());
        paramMap.put("packName", fileUrl.getPackName());
        paramMap.put("beanName", fileUrl.getBeanName());
        paramMap.put("cnObjectName", fileUrl.getCnObjectName());
//        paramMap.put("menuName", fileUrl.getMenuName());
//        paramMap.put("pageSort", fileUrl.getPageSort());
//        paramMap.put("menuSort", fileUrl.getMenuSort());
        genFile(paramMap,fileUrl.getServiceurl(),"Service","service.vm", basePath);
    }
    public static void genServiceImpl(String name ,String primaryType, String primaryKey, String basePath) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("serviceImplUrl", fileUrl.getServiceImplurl());
        paramMap.put("serviceUrl", fileUrl.getServiceurl());
        paramMap.put("mapperUrl", fileUrl.getDaourl());
        paramMap.put("url", fileUrl.getBeanurl());
        paramMap.put("exampleurl", fileUrl.getExampleurl());
        paramMap.put("name", name);
        paramMap.put("primaryType", primaryType);
        paramMap.put("primaryKey", primaryKey);
        paramMap.put("tableName", fileUrl.getTableName());
        paramMap.put("packName", fileUrl.getPackName());
        paramMap.put("beanName", fileUrl.getBeanName());
        paramMap.put("cnObjectName", fileUrl.getCnObjectName());
//        paramMap.put("menuName", fileUrl.getMenuName());
//        paramMap.put("pageSort", fileUrl.getPageSort());
//        paramMap.put("menuSort", fileUrl.getMenuSort());
        genFile(paramMap,fileUrl.getServiceImplurl(),"ServiceImpl","serviceImpl.vm", basePath);
    }
    public static void genDAO(String name ,String primaryType, String primaryKey, String basePath) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("mapperUrl", fileUrl.getDaourl());
        paramMap.put("url", fileUrl.getBeanurl());
        paramMap.put("exampleurl", fileUrl.getExampleurl());
        paramMap.put("name", name);
        paramMap.put("primaryType", primaryType);
        paramMap.put("primaryKey", primaryKey);
        paramMap.put("tableName", fileUrl.getTableName());
        paramMap.put("packName", fileUrl.getPackName());
        paramMap.put("beanName", fileUrl.getBeanName());
        paramMap.put("cnObjectName", fileUrl.getCnObjectName());
//        paramMap.put("menuName", fileUrl.getMenuName());
//        paramMap.put("pageSort", fileUrl.getPageSort());
//        paramMap.put("menuSort", fileUrl.getMenuSort());
        genFile(paramMap,fileUrl.getDaourl(),"Mapper","mapper.vm",basePath);
    }


    public static void genFile(Map<String, Object> paramMap,String fileurl,String filesuffix,String filetemplate,String basePath) throws Exception {
        //创建一个合适的Configration对象
        freemarker.template.Configuration configuration = new freemarker.template.Configuration(Configuration.VERSION_2_3_23 );
        //System.getProperty("user.dir")+File.separator+
        File baseFile =  new File(basePath);
        basePath = baseFile.getPath();
//        String templateGenDir = MySimpleXMLMapperGenerator.class.getClassLoader().getResource("templateGen").getFile();
        String templateGenDir = configDirPath+"templateGen/";
        File templateDir = new File(templateGenDir);
        configuration.setDirectoryForTemplateLoading(templateDir);
        configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_23));
        configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码
        //获取或创建一个模版。
        Template template = configuration.getTemplate(filetemplate);
        File file =new File(basePath+"/"+fileurl.replace(".","/"));
        if(!file.exists()){
            file.mkdirs();
        }
        logger.info(file.getPath());
        String filePath = basePath+"/"+fileurl.replace(".","/")+"/"+paramMap.get("name")+filesuffix+".java";
        Writer writer  = new OutputStreamWriter(new FileOutputStream(filePath ),"UTF-8");
        template.process(paramMap, writer);
        logger.info("恭喜，"+filePath+"生成成功~~");
    }
    
}
