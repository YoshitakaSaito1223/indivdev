package com.example.myapp.task;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {
	
	List<Task> findByUserid(int userid);
}
