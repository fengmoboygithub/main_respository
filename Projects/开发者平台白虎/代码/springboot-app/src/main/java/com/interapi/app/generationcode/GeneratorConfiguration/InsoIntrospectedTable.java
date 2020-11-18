package com.interapi.app.generationcode.GeneratorConfiguration;

import java.util.List;

import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.codegen.AbstractJavaClientGenerator;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;

public class InsoIntrospectedTable extends IntrospectedTableMyBatis3Impl {

    /**
     * XML的生成方法
     * @param javaClientGenerator
     * @param warnings
     * @param progressCallback
     */
    @Override
    protected void calculateXmlMapperGenerator(AbstractJavaClientGenerator javaClientGenerator, List<String> warnings, ProgressCallback progressCallback) {
        this.xmlMapperGenerator = new MySimpleXMLMapperGenerator();
        this.initializeAbstractGenerator(this.xmlMapperGenerator, warnings, progressCallback);
    }

    /**
     * Mapper类的生成方法
     * @return
     */
    @Override
    protected AbstractJavaClientGenerator createJavaClientGenerator() {
    	return super.createJavaClientGenerator();
    }

    /**
     * model类的生成方法
     * @param warnings
     * @param progressCallback
     */
    @Override
    protected void calculateJavaModelGenerators(List<String> warnings, ProgressCallback progressCallback) {
        super.calculateJavaModelGenerators(warnings, progressCallback);
    }
}
