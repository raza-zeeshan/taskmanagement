package com.taskmanagement.service;

import org.springframework.stereotype.Service;

import com.taskmanagement.entity.Userss;

@Service
public interface UserService {

	Userss saveUser(Userss userss);

	Userss findbyemail(String email);
}
