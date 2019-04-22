package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

}
