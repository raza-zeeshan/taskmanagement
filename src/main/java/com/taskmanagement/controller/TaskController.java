package com.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.taskmanagement.entity.Task;
import com.taskmanagement.entity.Userss;
import com.taskmanagement.service.TaskService;
import com.taskmanagement.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TaskController {
	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;

	@PostMapping("/createTask")
	public String creatTask() {
		return "task";
	}

	@PostMapping("/saveTask")
	public String saveTask(Task task, Model model, HttpSession httpSession) {
		String email = (String) httpSession.getAttribute("useremail");
		Userss userss = userService.findbyemail(email);
		if (userss != null) {
			task.setUserss(userss);
			Task tsk1 = taskService.saveTask(task);
			if (tsk1 != null) {
				return "home";
			} else {
				return "task";
			}
		} else {
			return "register";
		}

	}

}
