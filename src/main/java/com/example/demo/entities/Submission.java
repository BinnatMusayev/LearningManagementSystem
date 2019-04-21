package com.example.demo.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class Submission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer s_id;

	@ManyToOne
	private Task task;

	private String submitterName;
	private String s_desc;

	@CreationTimestamp
	private LocalDateTime submission_date;

	private Integer point;
}
