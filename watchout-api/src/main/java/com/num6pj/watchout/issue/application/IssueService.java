package com.num6pj.watchout.issue.application;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import com.num6pj.watchout.issue.domain.Issue;
import com.num6pj.watchout.issue.infra.IssueRepository;

@Service
public class IssueService {

    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public Issue createIssue(Issue issue) {
        issue.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        return issueRepository.save(issue);
    }
}
