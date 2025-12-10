package com.taskmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taskmanagement.entity.Task;
import com.taskmanagement.repository.TaskRepository;

@Component
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository repository;

	@Override
	public Task saveTask(Task task) {
		return repository.save(task);
	}

}
