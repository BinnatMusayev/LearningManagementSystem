package com.example.demo.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.entities.Teacher;

@SessionScope
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticatedUser {
    private Teacher teacher;
}
