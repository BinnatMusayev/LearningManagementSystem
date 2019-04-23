package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Task;
import com.example.demo.entities.Teacher;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {
	
	Task findByTaskId(Integer id);
	
	List<Task> findAllByTeacher(Teacher teacher);
}
