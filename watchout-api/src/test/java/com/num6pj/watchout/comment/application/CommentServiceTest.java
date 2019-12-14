package com.num6pj.watchout.comment.application;

import com.num6pj.watchout.comment.domain.Comment;
import com.num6pj.watchout.comment.infra.CommentRepository;
import com.num6pj.watchout.issue.domain.Issue;
import com.num6pj.watchout.issue.infra.IssueRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

public class CommentServiceTest {

    private CommentService commentService;
    private CommentRepository commentRepository;
    private IssueRepository issueRepository;


    @Test
    public void createComment() {

    }

    @Test
    public void adoptComment(){
        given(issueRepository.findById(1L)).willReturn(Optional.of(new Issue()));

        boolean adopt = true;

        Issue adopt_issue = issueRepository.findById(1L).orElse(null);
//        adopt_issue.set
        issueRepository.findById(1L).equals("true");

    }

}