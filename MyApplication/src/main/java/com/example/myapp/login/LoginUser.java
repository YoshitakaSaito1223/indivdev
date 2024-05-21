package com.example.myapp.login;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser  {
	
	private int id;
	
	private String name;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	private String email;

	private String birthday;
	
	private String gender;
	private String role;
	
	
}
