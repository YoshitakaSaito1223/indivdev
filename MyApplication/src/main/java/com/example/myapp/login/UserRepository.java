package com.example.myapp.login;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	User findByUsername(String username);
	int findIdByUsername(String username);
}
