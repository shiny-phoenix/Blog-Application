package com.spring_project.blog.blog_app_apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring_project.blog.blog_app_apis.entities.User;
import java.util.Optional;



public interface UserRepo extends JpaRepository<User,Integer> {
    
    Optional<User> findByEmail(String email);
}
