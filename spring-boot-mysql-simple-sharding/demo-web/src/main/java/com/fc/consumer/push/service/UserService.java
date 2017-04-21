package com.fc.consumer.push.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.fc.consumer.push.entity.User;
import com.fc.consumer.push.jdbc.UserRowMapper;

@Service
public class UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;

	public void saveUser(User user) {
		try {
			User oldUser = null;
			oldUser = get(user.getId(), user.getRole());
			if (null == oldUser) {
				insert(user);
			} else {
				update(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(User user) throws SQLException {
		Connection connection = dataSource.getConnection();
		updateUser(connection, user);
	}

	public void insert(User user) throws SQLException {
		Connection connection = dataSource.getConnection();
		insertUser(connection, user);
	}

	public User get(Integer id, Integer role) throws SQLException {
		User user = null;
		if (null == user) {
			user = selectUserWithPrepareStatement(dataSource.getConnection(), new User(id, null, 0, role));
		}
		return user;
	}

	private User selectUser(Connection connection, User user) throws SQLException {

		String sql = "select id, name, age, role from user where id = %d and role = %d";

		sql = String.format(sql, user.getId(), user.getRole());

		User foundUser = null;
		try (Statement statement = connection.createStatement()) {

			statement.execute(sql);

			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next()) {

				foundUser = getUserFromResultSet(resultSet);
			}
		}

		return foundUser;
	}

	private User selectUserWithPrepareStatement(Connection connection, User user) throws SQLException {

		String sql = "select id, name, age, role from user where id = ? and role = ?";

		User foundUser = null;
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setInt(1, user.getId());
			preparedStatement.setInt(2, user.getRole());

			preparedStatement.execute();

			ResultSet resultSet = preparedStatement.getResultSet();

			while (resultSet.next()) {

				foundUser = getUserFromResultSet(resultSet);
			}
		}

		return foundUser;
	}

	private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
		User foundUser;
		foundUser = new User();

		foundUser.setId(resultSet.getInt(1));
		foundUser.setName(resultSet.getString(2));
		foundUser.setAge(resultSet.getInt(3));
		foundUser.setRole(resultSet.getInt(4));
		return foundUser;
	}

	private void insertUser(Connection connection, User user) throws SQLException {

		String sql = "INSERT INTO user(id, name, age, role) VALUES (%d, '%s', %d, %d)";

		sql = String.format(sql, user.getId(), user.getName(), user.getAge(), user.getRole());

		try (Statement statement = connection.createStatement()) {

			statement.execute(sql);

		}
	}

	private void updateUser(Connection connection, User user) throws SQLException {

		String sql = "UPDATE user SET age = %d , name = '%s' WHERE  id = %d and role = %d";

		sql = String.format(sql, user.getAge(), user.getName(), user.getId(), user.getRole());

		try (Statement statement = connection.createStatement()) {

			statement.execute(sql);

		}

	}

	private void updateUserWithPrepareStatement(Connection connection, User user) throws SQLException {

		String sql = "UPDATE user SET age = ? , name = ? WHERE  id = ? and role = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setInt(1, user.getAge());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setInt(3, user.getId());
			preparedStatement.setInt(4, user.getRole());

			preparedStatement.execute();
		}

	}

	private void deleteUser(Connection connection, User user) throws SQLException {

		String sql = "DELETE FROM user WHERE  id = %d and role = %d";

		sql = String.format(sql, user.getId(), user.getRole());

		try (Statement statement = connection.createStatement()) {

			statement.execute(sql);

		}

	}

	private void deleteUserWithPrepareStatement(Connection connection, User user) throws SQLException {

		String sql = "DELETE FROM user WHERE  id = ? and role = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setInt(1, user.getId());
			preparedStatement.setInt(2, user.getRole());

			preparedStatement.execute();

		}

	}

}
