package com.example.myapp;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;

	@NotBlank(message = "必須項目です")
	@Email(message = "正しいメールアドレスを入力してください")
	private String email;

	@NotBlank(message = "必須項目です")
	private String name;

	@NotBlank(message = "必須項目です")
	private String username;

	@NotBlank(message = "必須項目です")
//	@Size(min = 8, max = 16)
	private String password;

//	@Transient
//	private String passwordComfirmation;

	//password確認用valid
//	@AssertTrue(message = "Passwordが一致しません。")
//	public boolean isPasswordValid() {
//		if (password == null || password.isEmpty()) {
//			return true;

//		}
//
//		return password.equals(passwordComfirmation);
//	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String birthday;

	@NotBlank(message = "必須項目です")
	private String gender;
	
	private String role="general";

	public User(String email, String name, String username, String password, String birthday, String gender) {
		super();
		this.email = email;
		this.name = name;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.gender = gender;
		this.role="general";
	}


}
