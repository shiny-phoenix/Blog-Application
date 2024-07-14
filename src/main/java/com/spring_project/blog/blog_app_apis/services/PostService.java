package com.spring_project.blog.blog_app_apis.services;

import java.util.List;
import com.spring_project.blog.blog_app_apis.payloads.PostDto;
import com.spring_project.blog.blog_app_apis.payloads.PostResponse;

public interface PostService {

    // create
    PostDto createPost (PostDto postDto, Integer userId, Integer categoryId);

    //update 
    PostDto updatePost(PostDto postDto, Integer postId);

    //delete
    void deletePost(Integer postId);

    //get all posts
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    //get single post
    PostDto getPostById(Integer postId);

    //get all post by category
    List<PostDto> getPostsByCategory(Integer categoryId);

    //get all posts by user
    List<PostDto> getPostsByUser(Integer userId);

    //search posts
    List<PostDto> searchPosts(String keyword);


}
