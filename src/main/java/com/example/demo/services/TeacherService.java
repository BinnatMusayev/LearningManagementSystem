package com.example.demo.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import com.example.demo.security.AuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Teacher;
import com.example.demo.repositories.TeacherRepository;

@Service
public class TeacherService implements UserDetailsService {
	@Autowired
    private TeacherRepository teacherRepository;
	
	@Autowired
    private AuthenticatedUser authenticatedUser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Teacher> oUser = teacherRepository.findByUsername(username);
        if (!oUser.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        Teacher t = oUser.get();
        authenticatedUser.setTeacher(t);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new org.springframework.security.core.userdetails.User(t.getUsername(), t.getPassword(), grantedAuthorities );
    }

}
