package com.spring_project.blog.blog_app_apis.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {  
    private Integer categoryId;

    @NotBlank
    @Size(min = 4, message = "Min size of categoryTitle is 4")
    private String categoryTitle;

    @NotBlank
    @Size(min = 10, message = "Min size of categoryTitle is 10")
    private String categoryDescription;
}