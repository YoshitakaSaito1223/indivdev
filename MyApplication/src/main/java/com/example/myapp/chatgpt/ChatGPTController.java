package com.example.myapp.chatgpt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatGPTController {

	@Autowired
	ChatGptApiClient api;
	
	@GetMapping("/chatgptapp")
	public String chatapp(Model model) {
		
		try {
			String sendPrompt="こんにちは!";
			model.addAttribute("response",api.callChatGptApi("user", sendPrompt));
			model.addAttribute("sendPrompt",sendPrompt);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return "chatgptapp";
	}
	
	@PostMapping("/chatgptapp")
	public String chatappReturn(@ModelAttribute("prompt")String prompt,Model model) {
		
		try {
			model.addAttribute("response",api.callChatGptApi("user", prompt));
			model.addAttribute("sendPrompt",prompt);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return "chatgptapp";
	}
	
}
