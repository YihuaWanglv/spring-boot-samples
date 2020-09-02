

# 说明

此代码例子特性：
- 使用mybatis接入phoenix连接的hbase
- 多数据源，同时接入mysql数据源和hbase数据源
- 使用RESTful标准接口演示如果操作phoenix连接的hbase，并实现分页


# 准备
phoenix-hbase建表语句：

```sql
create table see_knowledge_personal (
  id varchar not null primary key,
  student_id varchar,
  knowledge_subject_code varchar,
  knowledge_module_code varchar,
  knowledge_unit_code varchar,
  knowledge_point_code varchar,
  last_time timestamp,
  last_result varchar,
  right_num integer,
  memory_value integer,
  experience_value integer, 
  creater_user varchar,
  creater_time timestamp,
  modified_user varchar,
  modified_time timestamp
);
create index see_knowledge_personal_idx_student_id on see_knowledge_personal(student_id) include(id, knowledge_subject_code, knowledge_module_code, knowledge_unit_code, knowledge_point_code, last_time, last_result, right_num, memory_value, experience_value);
```

mysql建表语句：
```sql
CREATE TABLE `app_banner` (
  `banner_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `banner_title` varchar(100) NOT NULL COMMENT '标题',
  `link_url` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `image_url` varchar(255) DEFAULT NULL COMMENT '轮播图URL',
  `hide_in_minapp` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否在小程序中隐藏,1=隐藏，0=不隐藏',
  `sort` smallint(4) NOT NULL DEFAULT '0' COMMENT '顺序',
  `state` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态：0=下架，1=上架',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_user` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人用户ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新人用户ID',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除：0=未删除，1=已删除',
  PRIMARY KEY (`banner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
```

# 多数据源实现


多数据源配置的注意点是，包扫描有可能会相互影响，所以要将mysql和hbase的各自的entity、mapper、xml分开不同的文件夹，以避免相互影响


- 类：PhoenixMybatisConfig 配置Phoenix数据源和mybatis

```java
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


```

- 类：MysqlMybatisConfig 配置Mysql数据源和mybatis

```java
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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class MysqlMybatisConfig {


    private static final String MODEL_PACKAGE = "com.qkc.bus.phoenix.domains";
    private static final String MAPPER_PACKAGE = "com.qkc.bus.phoenix.mapper";
    private static final String MAPPER_INTERFACE_REFERENCE = "com.qkc.bus.phoenix.core.Mapper";

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTypeAliasesPackage(MODEL_PACKAGE);

        //添加插件
        SqlLog sqlLog = new SqlLog();
        //添加插件
        factory.setPlugins(new Interceptor[]{sqlLog});

        //添加XML目录。这个配置是配置对应的xml mapper文件的存放
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setMapperLocations(resolver.getResources("classpath:mappers/*.xml"));
        factory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return factory.getObject();
    }

    @Primary
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage(MAPPER_PACKAGE);

        //配置通用Mapper，详情请查阅官方文档
        Properties properties = new Properties();
        properties.setProperty("mappers", MAPPER_INTERFACE_REFERENCE);
        properties.setProperty("notEmpty", "false");//insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;
    }
}

```