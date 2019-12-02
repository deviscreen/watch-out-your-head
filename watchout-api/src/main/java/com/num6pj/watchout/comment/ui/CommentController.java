package com.num6pj.watchout.comment.ui;

import com.num6pj.watchout.comment.application.CommentService;
import com.num6pj.watchout.comment.domain.Comment;
import com.num6pj.watchout.comment.dto.AdoptCommentDto;
import com.num6pj.watchout.comment.dto.CreateCommentDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@RestController
public class CommentController {

    Logger logger = LoggerFactory.getLogger(CommentController.class);
    CommentService commentService;

    public CommentController( CommentService commentService){
        this.commentService = commentService;
    }
    //Issue를 받아오면 create
    @PostMapping("/comment/create")
    public ResponseEntity<?> createComment(@RequestBody CreateCommentDto commentDto) throws URISyntaxException {
        logger.info("IssueId : "+commentDto.getIssueId());
        URI location = new URI("/comment/create/1");
        commentService.createComment( new Comment(commentDto.getIssueId(),commentDto.getContext(), commentDto.getCommentUserId()));
        return ResponseEntity.created(location).body("");
    }

    @PatchMapping("/comment/adopt/{id}")
    public ResponseEntity<?> adoptComment(@PathVariable Long id, @RequestBody AdoptCommentDto adoptCommentDto) throws URISyntaxException {
        URI location = new URI("/comment/adopt/"+id);


        return ResponseEntity.created(location).body("Adopt Answer");
    }


}
