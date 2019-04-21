package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LMSController {

	@GetMapping("tasks")
	public String getTasks() {
		return "tasks_list";
	}

	@GetMapping("task")
	public String getTask() {
		return "task_details";
	}

	@GetMapping("submission")
	public String getSubmissions() {
		return "submission";
	}
}
