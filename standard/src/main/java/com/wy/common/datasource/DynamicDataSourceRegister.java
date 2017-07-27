package com.wy.common.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

 /**
 * 动�?�数据源注册<br/>
 * 启动动�?�数据源请在启动类中（如SpringBootSampleApplication�?
 * 添加 @Import(DynamicDataSourceRegister.class) 
 * @author linY [linyang@99114.com]
 * @version 
 * @since 2016�?5�?25�?
 */
/**
 * DynamicDataSourceRegister
 * @Copyright 北京网库信息技术股份有限公司
 * @Description: 动态数据源注册
 * 	启动动态数据源请在 启动类中（如SpringBootSampleApplication）
 * 	添加 @Import(DynamicDataSourceRegister.class)
 * @author libo
 * @date 2017年7月6日 下午4:33:57
 */
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware{
		
	private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceRegister.class);
    private static final Object DATASOURCE_TYPE_DEFAULT = "org.apache.tomcat.jdbc.pool.DataSource";
    private ConversionService conversionService = new DefaultConversionService();
    private Map<String, DataSource> customDataSources = new HashMap<String, DataSource>();
    private DataSource defaultDataSource;
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        if(customDataSources.size()==0){
            throw new IllegalArgumentException("no datasources init...");
        }
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        targetDataSources.putAll(customDataSources);
        for (String key : customDataSources.keySet()) {
            DynamicDataSourceContextHolder.dataSourceIds.add(key);
        }
        // 创建DynamicDataSource
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        mpv.addPropertyValue("defaultTargetDataSource", defaultDataSource);
        mpv.addPropertyValue("targetDataSources", targetDataSources);
        registry.registerBeanDefinition("dataSource", beanDefinition);
        logger.info("Dynamic DataSource Registry");
    }
    public DataSource buildDataSource(Map<String, Object> dsMap) {
        try {
            Object type = dsMap.get("type");
            if (type == null)
                type = DATASOURCE_TYPE_DEFAULT;// 默认DataSource
            Class<? extends DataSource> dataSourceType;
            dataSourceType = (Class<? extends DataSource>) Class.forName((String) type);
            DataSource result = (DataSource) BeanUtils.instantiate(dataSourceType);
            String driverClassName = dsMap.get("driverClassName").toString();
            String url = dsMap.get("url").toString();
            String username = dsMap.get("username").toString();
            String password = dsMap.get("password").toString();
            DataSourceBuilder factory = DataSourceBuilder.create().driverClassName(driverClassName).url(url)
                    .username(username).password(password).type(dataSourceType);
            return factory.build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 加载多数据源配置
     */
    @Override
    public void setEnvironment(Environment env) {
        initCustomDataSources(env);
    }
    private void dataBinder(DataSource dataSource, String dsPrefix, Environment env) {
        RelaxedDataBinder dataBinder = new RelaxedDataBinder(dataSource);
        dataBinder.setConversionService(conversionService);
        dataBinder.setIgnoreNestedProperties(false);//false
        dataBinder.setIgnoreInvalidFields(false);//false
        dataBinder.setIgnoreUnknownFields(true);//true
        Map<String, Object> rpr = new RelaxedPropertyResolver(env, "dynamicdatasource." + dsPrefix).getSubProperties(".");
        Map<String, Object> values = new HashMap<String, Object>(rpr);
        values.remove("type");
        values.remove("driver-class-name");
        values.remove("url");
        values.remove("username");
        values.remove("password");
        MutablePropertyValues dataSourcePropertyValues = new MutablePropertyValues(values);
        dataBinder.bind(dataSourcePropertyValues);
    }
    private void initCustomDataSources(Environment env) {
        // 读取配置文件获取更多数据�?
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, "dynamicdatasource.");
        String dsPrefixs = propertyResolver.getProperty("names");
        for (String dsPrefix : dsPrefixs.split(",")) {// 多个数据�?
            Map<String, Object> dsMap = propertyResolver.getSubProperties(dsPrefix + ".");
            DataSource ds = buildDataSource(dsMap);
            customDataSources.put(dsPrefix, ds);
            if(defaultDataSource==null){
                defaultDataSource=ds;
            }
            dataBinder(ds, dsPrefix, env);
        }
    }
}