package com.interapi.app.generationcode.GeneratorConfiguration;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.XMLMapperGenerator;

import com.interapi.app.generationcode.bean.FileUrl;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;


public class MySimpleXMLMapperGenerator extends XMLMapperGenerator {
    static FileUrl fileUrl;
    @Override
    protected XmlElement getSqlMapElement() {
    	FullyQualifiedTable table = introspectedTable.getFullyQualifiedTable();
        progressCallback.startTask(getString(
                "Progress.12", table.toString())); //$NON-NLS-1$
        XmlElement answer = new XmlElement("mapper"); //$NON-NLS-1$
        String namespace = introspectedTable.getMyBatis3SqlMapNamespace();
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
        String entityPath = introspectedTable.getBaseRecordType();
        String entityName = introspectedTable.getTableConfiguration().getDomainObjectName();
        String packName = entityPath.replaceAll("\\.model\\."+entityName, "");
        System.out.println(packName);
        String targetProject = context.getSqlMapGeneratorConfiguration().getTargetProject();
        System.out.println(targetProject);
        String primaryType = (introspectedTable.getPrimaryKeyColumns().get(0)).getFullyQualifiedJavaType().getShortName();
        String primaryKey = (introspectedTable.getPrimaryKeyColumns().get(0)).getJavaProperty();
        fileUrl.setExampleurl(introspectedTable.getExampleType());
        //fileUrl.setExampleurl(introspectedTable.getBaseRecordType()+"Example");
        fileUrl.setBeanurl(introspectedTable.getBaseRecordType());
        fileUrl.setPackName(packName);
        fileUrl.setControllerurl(packName+".controller");
        fileUrl.setDaourl(packName+".dao");
        fileUrl.setServiceImplurl(packName+".serviceImpl");
        fileUrl.setServiceurl(packName+".service");
        try {
            //genDAO( introspectedTable.getTableConfiguration().getDomainObjectName(),primaryType,primaryKey,targetProject);
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
        paramMap.put("capitalName", name);
        paramMap.put("packName", fileUrl.getPackName());
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
        paramMap.put("packName", fileUrl.getPackName());
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
        paramMap.put("packName", fileUrl.getPackName());
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
        paramMap.put("packName", fileUrl.getPackName());
        genFile(paramMap,fileUrl.getDaourl(),"Dao","mapper.vm",basePath);
    }


    public static void genFile(Map<String, Object> paramMap,String fileurl,String filesuffix,String filetemplate,String basePath) throws Exception {
        //创建一个合适的Configration对象
        freemarker.template.Configuration configuration = new freemarker.template.Configuration(Configuration.VERSION_2_3_23 );
        File baseFile =  new File(basePath);
        File parentFile = baseFile.getParentFile();
        configuration.setDirectoryForTemplateLoading(new File(parentFile, "resources/templateGen"));
        configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_23));
        configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码
        //获取或创建一个模版。
        Template template = configuration.getTemplate(filetemplate);
        File file =new File(basePath+"/"+fileurl.replace(".","/"));
        if(!file.exists()){
            file.mkdirs();
        }
        System.out.println(file.getPath());
        Writer writer  = new OutputStreamWriter(new FileOutputStream(basePath+"/"+fileurl.replace(".","/")+"/"+paramMap.get("name")+filesuffix+".java" ),"UTF-8");
        template.process(paramMap, writer);
        System.out.println("恭喜，"+filesuffix+"生成成功~~");
    }
}
