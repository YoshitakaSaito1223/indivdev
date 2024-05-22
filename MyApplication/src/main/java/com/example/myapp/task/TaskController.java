package com.example.myapp.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.myapp.login.UserRepository;

@Controller
public class TaskController {

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	SubTaskRepository subTaskRepository;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/todo")
	public String todo(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (taskRepository.findByUserid(userRepository.findByUsername(auth.getName()).getId()).isEmpty()) {
			return "todo";
		}

		model.addAttribute("tasks", taskRepository.findByUserid(userRepository.findByUsername(auth.getName()).getId()));

		return "todo";
	}

	//add task
	@PostMapping("/todo")
	public String Todo(Task task,  Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		System.out.println(task);
		if (!(task.isIscompleted())) {
			task.setUserid(userRepository.findByUsername(auth.getName()).getId());
			taskRepository.save(task);
		}
		
		taskRepository.save(task);

		model.addAttribute("tasks", taskRepository.findByUserid(userRepository.findByUsername(auth.getName()).getId()));

		return "todo";
	}

	
}
