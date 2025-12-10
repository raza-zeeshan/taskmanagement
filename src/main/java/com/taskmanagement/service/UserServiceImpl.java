package com.taskmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taskmanagement.entity.Userss;
import com.taskmanagement.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public Userss saveUser(Userss userss) {
		return repository.save(userss);
	}

	@Override
	public Userss findbyemail(String email) {
		return repository.findByEmail(email);
	}

}
