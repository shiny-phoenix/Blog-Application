package com.spring_project.blog.blog_app_apis.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.spring_project.blog.blog_app_apis.payloads.CommentDto;
import com.spring_project.blog.blog_app_apis.services.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/apis")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/posts/{postId}/comments")    
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId){

        CommentDto createdCommentDto = this.commentService.createComment(comment, postId);

        return new ResponseEntity<CommentDto>(createdCommentDto,HttpStatus.CREATED);

    }

    @DeleteMapping("/comments/{commentId}")    
    public ResponseEntity<String> createComment( @PathVariable Integer commentId){
        
        this.commentService.deleteComment(commentId);

        return new ResponseEntity<String>("Comment deleted successfully",HttpStatus.OK);

    }
}
