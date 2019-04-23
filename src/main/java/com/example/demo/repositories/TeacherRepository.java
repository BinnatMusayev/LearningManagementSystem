package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
	Optional<Teacher> findByUsername(String username);
}
