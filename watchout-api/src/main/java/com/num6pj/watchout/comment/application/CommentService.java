package com.num6pj.watchout.comment.application;

import com.num6pj.watchout.comment.domain.Comment;
import com.num6pj.watchout.comment.infra.CommentRepository;
import com.num6pj.watchout.issue.domain.Issue;
import com.num6pj.watchout.issue.infra.IssueRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    final private CommentRepository commentRepository;
    final private IssueRepository issueRepository;
    public CommentService( CommentRepository commentRepository,IssueRepository issueRepository){

        this.commentRepository = commentRepository;
        this.issueRepository = issueRepository;
    }



    public void createComment( Comment comment){
        commentRepository.save( comment);
    }

    public void updateCommentState( Issue issue ) {
        commentRepository.findById(issue.getIssueId()).get().setAdoptedStatus(true);
    }
    public void updateCommentState(Long id){
        Issue issue = issueRepository.findById(id).orElse(null);
        //comment adopted
        commentRepository.findById(issue.getIssueId()).get().setAdoptedStatus(true);
        //issue adopted
        issue.setCompleted(true);
    }



}
