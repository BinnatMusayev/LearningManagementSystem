package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Submission;
import com.example.demo.entities.Task;
import com.example.demo.repositories.SubmissionRepository;
import com.example.demo.repositories.TaskRepository;
import com.example.demo.repositories.TeacherRepository;
import com.example.demo.security.AuthenticatedUser;

@Controller
@RequestMapping("/")
public class LMSController {
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private SubmissionRepository submissionRepo;
	
	@Autowired
	private AuthenticatedUser user;
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("tasks")
	public String getTasks(Model model) {
		model.addAttribute("tasks", taskRepo.findAllByTeacher(user.getTeacher()));
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

	@GetMapping("tasks/{tid}/submission/{id}")
	public String getSubmissions(@PathVariable Integer id, @PathVariable Integer tid, Model model) {
		
		Optional<Submission> submission = submissionRepo.findById(id);
		model.addAttribute("sub", submission.get());
		model.addAttribute("taskId", tid);
		
		return "submission";
	}
	
	@PostMapping("tasks/{tid}/submission/{id}/edit")
    public String editSubmission(@PathVariable Integer id, @PathVariable Integer tid, @RequestParam("selectPoint") Integer point) {
        
        Submission sub = submissionRepo.findById(id).get();
        sub.setPoint(point);
        submissionRepo.save(sub);
        return "redirect:/tasks/{tid}";
    }
}
