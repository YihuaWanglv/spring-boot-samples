package com.qkc.bus.phoenix.config;


import com.qkc.bus.phoenix.core.SqlLog;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;

@Configuration
public class PhoenixMybatisConfig {


    private static final String MODEL_PACKAGE = "com.qkc.bus.phoenix.hbase.domains";
    private static final String MAPPER_PACKAGE = "com.qkc.bus.phoenix.hbase.mapper";

    @Bean(name = "phoenixDataSource")
    @ConfigurationProperties(prefix = "spring.phoenix-datasource")
    public DataSource phoenixDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "phoenixSqlSessionFactory")
    public SqlSessionFactory phoenixSqlSessionFactory(@Qualifier("phoenixDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTypeAliasesPackage(MODEL_PACKAGE);

        //添加插件
        SqlLog sqlLog = new SqlLog();
        //添加插件
        factory.setPlugins(new Interceptor[]{sqlLog});

        //添加XML目录。这个配置是配置对应的xml mapper文件的存放
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setMapperLocations(resolver.getResources("classpath:phoenix-mappers/*.xml"));
        factory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return factory.getObject();
    }

    @Bean(name = "phoenixMapperScannerConfigurer")
    public MapperScannerConfigurer phoenixMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("phoenixSqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(MAPPER_PACKAGE);
        return mapperScannerConfigurer;
    }
}
