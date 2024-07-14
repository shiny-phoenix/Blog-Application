package com.spring_project.blog.blog_app_apis.services;

import java.util.List;
import com.spring_project.blog.blog_app_apis.payloads.UserDto;

public interface UserService {
    UserDto registerNewUser(UserDto user);
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);
}
