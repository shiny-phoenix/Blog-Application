package com.spring_project.blog.blog_app_apis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring_project.blog.blog_app_apis.entities.User;
import com.spring_project.blog.blog_app_apis.exceptions.ResourceNotFoundException;
import com.spring_project.blog.blog_app_apis.repositories.UserRepo;

@Service
public class CustomUserDetails implements UserDetailsService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        //load user from database via username
        User user = this.userRepo.findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("user", "email : "+ username,0));
        
        return user;
        
    }

}
