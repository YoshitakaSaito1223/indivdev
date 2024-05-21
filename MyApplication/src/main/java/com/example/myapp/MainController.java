package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.myapp.login.LoginUser;
import com.example.myapp.login.UserRepository;
import com.example.myapp.login.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    private UserService userService;

	@GetMapping("/index")
	public String getIndex() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 現在のユーザーの認証情報を取得します
		return "index";
	}
	
	@GetMapping("/login")
	public String Login() {
		return "login";
	}


	
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("user",new User());
		return "registration";
	}
	
	@PostMapping("/registration_check")
	public String registrationCheck(@Validated @ModelAttribute("user") User user,BindingResult bindingResult,Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("user", user);
			return "registration";
		}

		model.addAttribute("user", user);

		return "registration_check";
			
	}
	
	@PostMapping("/registration_completed")
	public String registrationCompleted(@ModelAttribute("user") LoginUser loginUser,Model model) {
		userService.save(loginUser);
		
		return "/registration_completed";
	}
	
	@GetMapping("/home")
	public String Home() {
		return "home";
	}
	
	
	
}
