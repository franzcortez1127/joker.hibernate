package com.joker.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joker.hibernate.model.M_User;
import com.joker.hibernate.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="getall")
	public List<M_User> getAllCustomers(){
		return userService.findAllUsers();
	}
}
