package com.iyihua.demo.sharding.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.iyihua.demo.sharding.entity.User;
import com.iyihua.demo.sharding.jdbc.UserRowMapper;

@Service
public class UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveUser(User user) {
		try {
			User oldUser = null;
			oldUser = get(user.getId());
			if (null == oldUser) {
				insert(user);
			} else {
				update(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(User user) {
		jdbcTemplate.update("update user set name=?, age=?, role=? where id=?", user.getId(), user.getName(),
				user.getAge(), user.getRole());
	}

	public void insert(User user) {
		jdbcTemplate.update("insert into user (id, name, age, role) values(?,?,?,?)", user.getId(), user.getName(),
				user.getAge(), user.getRole());
	}

	@SuppressWarnings("unchecked")
	public User get(Integer id) throws SQLException {
		User user = (User) jdbcTemplate.queryForObject("select * from user where id=?", new Object[] { id },
				new UserRowMapper());
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> listAll() {
		List<User> users = jdbcTemplate.query("select * from user where 1=1", new UserRowMapper());
		return users;
	}

	@SuppressWarnings("unchecked")
	public List<User> listByRole(Integer role) {
		List<User> users = jdbcTemplate.query("select * from user where 1=1 and role=?", new Object[] { role },
				new UserRowMapper());
		return users;
	}

	public List<Map<String, Object>> groupByRole() {
		List<java.util.Map<String, Object>> rs = jdbcTemplate
				.queryForList("select role, count(*) as count from user where 1=1 group by role");
		return rs;
	}

	@SuppressWarnings("unchecked")
	public List<User> listByPage(Integer page, Integer size) {
		Integer start = (page - 1) * size;
		List<User> users = jdbcTemplate.query("select * from user where 1=1 order by id limit ?, ?",
				new Object[] { start, size }, new UserRowMapper());
		return users;
	}

}
