package com.num6pj.watchout.comment.application;

import com.num6pj.watchout.comment.domain.Comment;
import com.num6pj.watchout.comment.infra.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    final CommentRepository commentRepository;

    public CommentService( CommentRepository commentRepository){

        this.commentRepository = commentRepository;
    }


    public void createComment( Comment comment){
        commentRepository.save( comment);
    }



}
