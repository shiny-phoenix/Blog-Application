package com.spring_project.blog.blog_app_apis.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.spring_project.blog.blog_app_apis.exceptions.ApiException;
import com.spring_project.blog.blog_app_apis.payloads.JwtAuthRequest;
import com.spring_project.blog.blog_app_apis.payloads.JwtAuthResponse;
import com.spring_project.blog.blog_app_apis.payloads.UserDto;
import com.spring_project.blog.blog_app_apis.security.JwtTokenHelper;
import com.spring_project.blog.blog_app_apis.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/apis/v1/auth")

public class AuthController {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> cerateToken(@RequestBody JwtAuthRequest request) throws Exception {

        this.authenticate(request.getUsername(), request.getPassword());

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());

        String token = this.jwtTokenHelper.generateToken(userDetails);

        JwtAuthResponse response = new JwtAuthResponse();
        response.setToken(token);

        return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);

    }

    private void authenticate(String userName, String password) throws Exception {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                userName, password);
                
            
        try {
            this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (BadCredentialsException e) {
            System.out.println("Invalid details");

            throw new ApiException("Invali username or password !!");
        }
    }

    //register new user api
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){

        UserDto registerNewUser = this.userService.registerNewUser(userDto);

        return new ResponseEntity<UserDto>(registerNewUser, HttpStatus.CREATED);
    }
}
