package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Submission;
import com.example.demo.entities.Task;
import com.example.demo.entities.Teacher;

@Repository
public interface SubmissionRepository extends CrudRepository<Submission, Integer> {

	List<Submission> findAllByTask(Task task);
}
