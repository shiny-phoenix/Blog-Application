package com.spring_project.blog.blog_app_apis.payloads;

import java.util.Set;
import java.util.HashSet;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Integer id;

    @NotEmpty
    @Size(min = 4, message = "Username must be at least of 4 characters")
    private String name;

    @Email(message = "Invalid Email")
    private String email;

    @NotEmpty
    @Size(min= 3, max = 10, message = "Password must be at least of 3 and max 10 characters" )
    private String password;

    private String about;

    private Set<RoleDto> roles = new HashSet<>();
}
