package com.spring_project.blog.blog_app_apis.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_project.blog.blog_app_apis.entities.Comment;
import com.spring_project.blog.blog_app_apis.entities.Post;
import com.spring_project.blog.blog_app_apis.exceptions.ResourceNotFoundException;
import com.spring_project.blog.blog_app_apis.payloads.CommentDto;
import com.spring_project.blog.blog_app_apis.repositories.CommentRepo;
import com.spring_project.blog.blog_app_apis.repositories.PostRepo;
import com.spring_project.blog.blog_app_apis.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);

        comment.setPost(post);

        Comment savedComment = this.commentRepo.save(comment);

        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {

        Comment comment = this.commentRepo.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("comment", "id", commentId));

        this.commentRepo.delete(comment);

    }

}
