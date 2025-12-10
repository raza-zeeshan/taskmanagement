package com.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.taskmanagement.entity.LoginUser;
import com.taskmanagement.entity.Userss;
import com.taskmanagement.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller

public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/")
	public String register() {
		return "register";
	}

	@PostMapping("/createuser")
	public String createuser(Userss userss, Model model) {
		System.out.println(userss.getName());

		// save user data in DB
		Userss save = service.saveUser(userss);

		if (save != null) {
			return "login";
		} else {
			model.addAttribute("msg", "Registration Failed!!!");
			return "register";
		}

	}

	@PostMapping("/login")
	public String login(LoginUser loginUser, Model model, HttpSession httpSession) {
		httpSession.setAttribute("useremail", loginUser.getEmail());
		Userss userss = service.findbyemail(loginUser.getEmail());
		if (userss != null) {
			model.addAttribute("msg", "Login Successfull");
			return "home";
		} else {
			model.addAttribute("msg", "Login Failed!!!");
			return "login";
		}
	}

}
