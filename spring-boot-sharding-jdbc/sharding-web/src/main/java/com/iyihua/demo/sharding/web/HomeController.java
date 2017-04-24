package com.iyihua.demo.sharding.web;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iyihua.demo.sharding.entity.User;
import com.iyihua.demo.sharding.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;

	@RequestMapping("/")
	@ResponseBody
	String index() {
		return "App is running......";
	}

	@RequestMapping("/get")
	@ResponseBody
	Object get(Integer id) throws SQLException {
		return userService.get(id);
	}

	@RequestMapping("/save")
	@ResponseBody
	Object save(Integer id, String name, Integer age, Integer role) throws SQLException {
		User user = new User(id, name, age, role);
		userService.saveUser(user);
		return user;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	Object create(Integer id, String name, Integer age, Integer role) throws SQLException {
		User user = new User(id, name, age, role);
		userService.insert(user);
		return user;
	}
	
	@RequestMapping("/all")
	@ResponseBody
	Object listAll() throws SQLException {
		return userService.listAll();
	}
	
	@RequestMapping("/listByRole")
	@ResponseBody
	Object listByRole(Integer role) throws SQLException {
		return userService.listByRole(role);
	}
	
	@RequestMapping("/groupByRole")
	@ResponseBody
	Object groupByRole(Integer role) throws SQLException {
		return userService.groupByRole();
	}

	@RequestMapping("/listByPage")
	@ResponseBody
	Object listByPage(Integer page, Integer size) throws SQLException {
		return userService.listByPage(page, size);
	}
	
}
