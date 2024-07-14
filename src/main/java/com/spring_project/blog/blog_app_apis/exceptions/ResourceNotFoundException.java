package com.spring_project.blog.blog_app_apis.exceptions;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
    String resourceName;
    String fieldName;
    Integer fieldValue;
    public ResourceNotFoundException( String resourceName, String fieldName, Integer fieldValue) {
        super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
    
    
    
}
