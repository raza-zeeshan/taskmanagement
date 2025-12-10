package com.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanagement.entity.Userss;

public interface UserRepository extends JpaRepository<Userss, Integer> {

	Userss findByEmail(String email);

}
