package com.num6pj.watchout.comment.application;

import com.num6pj.watchout.comment.domain.Comment;
import com.num6pj.watchout.comment.dto.CreateCommentDto;
import com.num6pj.watchout.comment.infra.CommentRepository;
import com.num6pj.watchout.issue.domain.Issue;
import com.num6pj.watchout.issue.infra.IssueRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CommentService {

    final private CommentRepository commentRepository;
    final private IssueRepository issueRepository;
    public CommentService( CommentRepository commentRepository,IssueRepository issueRepository){

        this.commentRepository = commentRepository;
        this.issueRepository = issueRepository;
    }



    public void createComment( CreateCommentDto commentDto){
        Issue issue = issueRepository.findById(commentDto.getIssueId())
                .orElseThrow(() -> new NoSuchElementException("don'tfind Issue"));
        commentRepository.save( new Comment(issue,commentDto.getContext(), commentDto.getCommentUserId()));

    }

//    public void updateCommentState( Issue issue ) {
//        commentRepository.findById(issue.getIssueId()).get().setAdoptedStatus(true);
//    }
    public void updateCommentState(Long commentId){
        /* TODO 연관관계 맵핑 후 재구성 */
        Comment comment = commentRepository.findById(commentId).orElse(null);
        //comment adopted
        comment.setAdoptedStatus(true);
        //issue adopted
        comment.getIssue().setCompleted(true);
    }



}
