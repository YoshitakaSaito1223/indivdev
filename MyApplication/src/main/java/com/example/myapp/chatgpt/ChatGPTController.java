package com.example.myapp.chatgpt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatGPTController {

	@Autowired
	ChatGptApiClient api;
	
	@GetMapping("/chatgptapp")
	public String chatapp(Model model) {
		
		try {
			model.addAttribute("response",api.callChatGptApi("user", "こんにちは"));
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return "chatgptapp";
	}
}
