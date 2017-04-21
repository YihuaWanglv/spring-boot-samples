package com.fc.consumer.push.web;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.consumer.push.entity.User;
import com.fc.consumer.push.service.UserService;

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
	Object get(Integer id, Integer role) throws SQLException {
		return userService.get(id, role);
	}

	@RequestMapping("/create")
	@ResponseBody
	Object create(Integer id, String name, Integer age, Integer role) throws SQLException {

		User user = new User(id, name, age, role);
		userService.saveUser(user);
//		userService.insert(user);
		return user;
	}

}
