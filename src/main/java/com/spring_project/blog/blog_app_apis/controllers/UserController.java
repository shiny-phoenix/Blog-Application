package com.spring_project.blog.blog_app_apis.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring_project.blog.blog_app_apis.payloads.UserDto;
import com.spring_project.blog.blog_app_apis.services.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/apis/users")
public class UserController {

    @Autowired
    private UserService userService;

    //POST - create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser( @Valid @RequestBody UserDto userDto){
        UserDto createdUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    //PUT -update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser( @Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer uid){
        UserDto user = this.userService.updateUser(userDto, uid);
        return  ResponseEntity.ok(user);

    }

    //DELETE  - delete user
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping( "/{userId}")
    public String  deleteUser( @PathVariable("userId") Integer uid){
        this.userService.deleteUser(uid);
        return "User deleted successfully";
    }

    //GET - user get
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){

        
    
        return  ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser( @PathVariable("userId") Integer uid){
    
        return  ResponseEntity.ok(this.userService.getUserById(uid));
    }
    
}
