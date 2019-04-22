package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Submission;
import com.example.demo.entities.Task;
import com.example.demo.repositories.SubmissionRepository;
import com.example.demo.repositories.TaskRepository;
import com.example.demo.repositories.TeacherRepository;

@Controller
@RequestMapping("/")
public class LMSController {
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private SubmissionRepository submissionRepo;

	@GetMapping("tasks")
	public String getTasks(Model model) {
		model.addAttribute("tasks", taskRepo.findAll());
		return "tasks_list";
	}

	@GetMapping("tasks/{id}")
	public String getTask(@PathVariable Integer id, Model model) {
		Task task = taskRepo.findByTaskId(id);
		model.addAttribute("task", task);
		
		List<Submission> submissions = submissionRepo.findAllByTask(task);
		model.addAttribute("submissions", submissions);
		
		return "task_details";
	}

	@GetMapping("submission/{id}")
	public String getSubmissions(@PathVariable Integer id, Model model) {
		
		Optional<Submission> submission = submissionRepo.findById(id);
		model.addAttribute("sub", submission.get());
		
		return "submission";
	}
}
