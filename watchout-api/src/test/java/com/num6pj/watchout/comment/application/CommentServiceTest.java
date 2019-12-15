package com.num6pj.watchout.comment.application;

import com.num6pj.watchout.comment.domain.Comment;
import com.num6pj.watchout.comment.infra.CommentRepository;
import com.num6pj.watchout.issue.domain.Issue;
import com.num6pj.watchout.issue.infra.IssueRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

public class CommentServiceTest {

    private CommentService commentService;
    @Mock
    private CommentRepository commentRepository;
    @Mock
    private IssueRepository issueRepository;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        commentService = new CommentService( commentRepository, issueRepository);
    }

    @Test
    public void createComment() {
        System.out.println(new Date().getTime());
    }
    @Test
    public void adoptComment(){
        long time = new Date().getTime();
       given(issueRepository.findById(any()))
               .willReturn(
                       Optional.of(
                               Issue.builder()
                                       .Category("category")
                                       .issueId(1L)
                                       .context("Context10101000101010")
                                       .writerUserId(1L)
                                       .closeDate(new Timestamp(time))
                                       .createdDate(new Timestamp(time))
                                       .modifiedDate(new Timestamp(time))
                                       .price(3000L)
                                       .title("Question")
                                       .isCompleted(false)
                                       .build()
               ));

       given(commentRepository.findById(1L))
               .willReturn(
                       Optional.of(
                               new Comment(1L, "Answer", 2L)
                       )
               );
//        Issue adopt_issue = issueRepository.findById(1L).get();
        commentService.updateCommentState( 1L);
        Issue adopt_issue = issueRepository.findById(1L).get();
        assertThat(adopt_issue.isCompleted(),is(true));


    }

}