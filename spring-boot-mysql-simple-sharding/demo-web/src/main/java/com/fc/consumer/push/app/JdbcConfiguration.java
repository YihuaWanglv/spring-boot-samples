package com.fc.consumer.push.app;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.yuanwhy.simple.sharding.jdbc.LogicDataSource;
import com.yuanwhy.simple.sharding.rule.HashShardingRule;
import com.yuanwhy.simple.sharding.rule.ShardingRule;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 数据库配置bean
 * 
 * @author wanglvyihua
 * @date 2017年3月1日
 *
 */
@Configuration
public class JdbcConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public ShardingRule shardingRule() {
		HashShardingRule shardingRule = new HashShardingRule();
		shardingRule.setFieldNameForDb("role");
		shardingRule.setFieldNameForTable("id");
		shardingRule.setDbCount(2);
		shardingRule.setTableCount(2);
		return shardingRule;
	}

	@Bean
	public DataSource physicalDataSource0() {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(env.getProperty("db0.url"));
		ds.setUsername(env.getProperty("db0.username"));
		ds.setPassword(env.getProperty("db0.password"));
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setMaximumPoolSize(30);
		ds.setMinimumIdle(10);
		ds.setConnectionTestQuery("SELECT 1");
		ds.setIdleTimeout(300000);
		return ds;
	}

	@Bean
	public DataSource physicalDataSource1() {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(env.getProperty("db1.url"));
		ds.setUsername(env.getProperty("db1.username"));
		ds.setPassword(env.getProperty("db1.password"));
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setMaximumPoolSize(30);
		ds.setMinimumIdle(10);
		ds.setConnectionTestQuery("SELECT 1");
		ds.setIdleTimeout(300000);
		return ds;
	}

	@Bean
	public DataSource dataSource(ShardingRule shardingRule, DataSource physicalDataSource0,
			DataSource physicalDataSource1) {
		LogicDataSource ds = new LogicDataSource();
		ds.setLogicDatabase("passport");
		ds.setShardingRule(shardingRule);

		Map<String, DataSource> physicalDataSourceMap = new HashMap<>();
		physicalDataSourceMap.put("passport_0", physicalDataSource0);
		physicalDataSourceMap.put("passport_1", physicalDataSource1);
		ds.setPhysicalDataSourceMap(physicalDataSourceMap);
		return ds;
	}
}
