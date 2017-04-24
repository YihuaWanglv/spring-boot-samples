package com.iyihua.demo.sharding.app;

import java.util.HashMap;
import java.util.List;
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

import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSource;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.google.common.collect.Lists;
import com.iyihua.demo.sharding.core.algorithm.SingleKeyModuloDatabaseShardingAlgorithm;
import com.iyihua.demo.sharding.core.algorithm.SingleKeyModuloTableShardingAlgorithm;
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

	/**
	 * 数据源0
	 * @return
	 */
	@Bean
	public DataSource ds_0() {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(env.getProperty("db0.url"));
		ds.setUsername(env.getProperty("db0.username"));
		ds.setPassword(env.getProperty("db0.password"));
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		return ds;
	}

	/**
	 * 数据源1
	 * @return
	 */
	@Bean
	public DataSource ds_1() {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(env.getProperty("db1.url"));
		ds.setUsername(env.getProperty("db1.username"));
		ds.setPassword(env.getProperty("db1.password"));
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		return ds;
	}

	/**
	 * 真正使用的数据源
	 * @param ds_0
	 * @param ds_1
	 * @return
	 */
	@Bean
	public DataSourceRule dataSource(DataSource ds_0, DataSource ds_1) {
		Map<String, DataSource> dataSourceMap = new HashMap<>();
		dataSourceMap.put("ds_0", ds_0);
		dataSourceMap.put("ds_1", ds_1);
		DataSourceRule dsr = new DataSourceRule(dataSourceMap);
		return dsr;
	}

	/**
	 * user的"分表"设置:分N个表
	 * @param dataSource
	 * @return
	 */
	@Bean
	public TableRule orderTableRule(DataSourceRule dataSource) {
		List<String> actualTables = Lists.newArrayList("user_0", "user_1");
		TableRule tr = new TableRule("user", actualTables, dataSource);

		return tr;
	}

	/**
	 * 分库的sharding规则:按user表的role分库
	 * @return
	 */
	@Bean
	public DatabaseShardingStrategy databaseShardingStrategy() {
		SingleKeyModuloDatabaseShardingAlgorithm databaseShardingAlgorithm = new SingleKeyModuloDatabaseShardingAlgorithm();
		databaseShardingAlgorithm.setDbCount(2);
		DatabaseShardingStrategy dss = new DatabaseShardingStrategy("role", databaseShardingAlgorithm);
		return dss;
	}

	/**
	 * tableCount的值要跟上面orderTableRule的user表设置的分表个数保持一致
	 * @return
	 */
	@Bean
	public SingleKeyModuloTableShardingAlgorithm singleKeyModuloTableShardingAlgorithm() {
		SingleKeyModuloTableShardingAlgorithm singleKeyModuloTableShardingAlgorithm = new SingleKeyModuloTableShardingAlgorithm();
		singleKeyModuloTableShardingAlgorithm.setTableCount(2);
		return singleKeyModuloTableShardingAlgorithm;
	}

	/**
	 * 分表的规则:按user表的id字段分表
	 * @param singleKeyModuloTableShardingAlgorithm
	 * @return
	 */
	@Bean
	public TableShardingStrategy tableShardingStrategy(
			SingleKeyModuloTableShardingAlgorithm singleKeyModuloTableShardingAlgorithm) {
		TableShardingStrategy tss = new TableShardingStrategy("id", singleKeyModuloTableShardingAlgorithm);
		return tss;
	}

	/**
	 * sharding规则Bean
	 * @param dataSource
	 * @param orderTableRule
	 * @param databaseShardingStrategy
	 * @param tableShardingStrategy
	 * @return
	 */
	@Bean
	public ShardingRule shardingRule(DataSourceRule dataSource, TableRule orderTableRule,
			DatabaseShardingStrategy databaseShardingStrategy, TableShardingStrategy tableShardingStrategy) {
		ShardingRule shardingRule = new ShardingRule(dataSource, Lists.newArrayList(orderTableRule),
				databaseShardingStrategy, tableShardingStrategy);
		return shardingRule;
	}

	/**
	 * sharding数据源
	 * @param shardingRule
	 * @return
	 */
	@Bean
	public ShardingDataSource shardingDataSource(ShardingRule shardingRule) {
		ShardingDataSource shardingDataSource = new ShardingDataSource(shardingRule);
		return shardingDataSource;
	}

	/**
	 * JdbcTemplate配置
	 * @param shardingDataSource
	 * @return
	 */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource shardingDataSource) {
		return new JdbcTemplate(shardingDataSource);
	}

	@Bean
	public PlatformTransactionManager transactionManager(DataSource shardingDataSource) {
		return new DataSourceTransactionManager(shardingDataSource);
	}

}
