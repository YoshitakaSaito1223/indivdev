package com.example.myapp.login;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	User findByUsername(String username);
	List<User> findIdByUsername(String username);
}
