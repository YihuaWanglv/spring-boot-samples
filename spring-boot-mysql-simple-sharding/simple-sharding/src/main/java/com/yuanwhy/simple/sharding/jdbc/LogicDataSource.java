package com.yuanwhy.simple.sharding.jdbc;

import com.yuanwhy.simple.sharding.rule.ShardingRule;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by yuanwhy on 17/3/27.
 */
public class LogicDataSource implements DataSource {

    private String logicDatabase;

    private Map<String, DataSource> physicalDataSourceMap;

    private ShardingRule shardingRule;

    public String getLogicDatabase() {
        return logicDatabase;
    }

    public void setLogicDatabase(String logicDatabase) {
        this.logicDatabase = logicDatabase;
    }

    public Map<String, DataSource> getPhysicalDataSourceMap() {
        return physicalDataSourceMap;
    }

    public void setPhysicalDataSourceMap(Map<String, DataSource> physicalDataSourceMap) {
        this.physicalDataSourceMap = physicalDataSourceMap;
    }

    public ShardingRule getShardingRule() {
        return shardingRule;
    }

    public void setShardingRule(ShardingRule shardingRule) {
        this.shardingRule = shardingRule;
    }

    @Override
    public Connection getConnection() throws SQLException {

        Connection connection = new LogicConnection(this);

        return connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
