package com.fc.consumer.push.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fc.consumer.push.entity.User;

/**
 * User的Jdbc字段映射RowMapper
 * 
 * @author wanglvyihua
 * @date 2017年3月1日
 *
 */
@SuppressWarnings("rawtypes")
public class UserRowMapper implements RowMapper {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setAge(rs.getInt("age"));
		user.setRole(rs.getInt("role"));
		return user;
	}

}
