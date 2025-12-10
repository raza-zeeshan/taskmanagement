package com.taskmanagement.service;

import org.springframework.stereotype.Service;

import com.taskmanagement.entity.Task;

@Service
public interface TaskService {
	Task saveTask(Task task);
}
