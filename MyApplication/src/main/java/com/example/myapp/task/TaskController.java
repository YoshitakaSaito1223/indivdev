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

		model.addAttribute("tasks", taskRepository.findByUseridAndIscompletedAndIsdeleted(userRepository.findByUsername(auth.getName()).getId(),false,false));

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

		model.addAttribute("tasks", taskRepository.findByUseridAndIscompletedAndIsdeleted(userRepository.findByUsername(auth.getName()).getId(),false,false));

		return "todo";
	}
	
	@GetMapping("/todo/uncompleted")
	public String uncompletedTask(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		model.addAttribute("tasks", taskRepository.findByUseridAndIscompletedAndIsdeleted(userRepository.findByUsername(auth.getName()).getId(),false,false));
		
		return "todo";
	}
	
	@GetMapping("/todo/completed")
	public String completedTask(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		model.addAttribute("tasks", taskRepository.findByUseridAndIscompletedAndIsdeleted(userRepository.findByUsername(auth.getName()).getId(),true,false));
		
		return "todo";
	}
	
	@GetMapping("/todo/deleted")
	public String deletedTask(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		model.addAttribute("tasks", taskRepository.findByUseridAndIsdeleted(userRepository.findByUsername(auth.getName()).getId(),true));
		
		return "todo";
	}
	
	@PostMapping("/todo/sub")
	public String subTask(SubTask subTask,Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println(subTask);
		if (!(subTask.isIscompleted())) {
			subTask.setUserid(userRepository.findByUsername(auth.getName()).getId());
			subTaskRepository.save(subTask);
		}
		taskRepository.save(subTask);

		model.addAttribute("tasks", taskRepository.findByUserid(userRepository.findByUsername(auth.getName()).getId()));
		
		return "todo";
	}

	
}
