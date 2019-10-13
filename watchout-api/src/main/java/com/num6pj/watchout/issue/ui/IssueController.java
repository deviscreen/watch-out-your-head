package com.num6pj.watchout.issue.ui;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.net.URI;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.num6pj.watchout.issue.application.IssueService;
import com.num6pj.watchout.issue.domain.Issue;
import com.num6pj.watchout.issue.dto.IssueDto;

@Controller
public class IssueController {

    private final IssueService issueService;
    private final IssueValidator issueValidator;
    private final ModelMapper modelMapper;

    public IssueController(IssueService issueService, IssueValidator issueValidator, ModelMapper modelMapper) {
        this.issueService = issueService;
        this.issueValidator = issueValidator;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/issue", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity createIssue(@RequestBody @Valid IssueDto issueDto, Errors errors) {

        issueValidator.validate(issueDto, errors);
        if(errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        Issue issue = modelMapper.map(issueDto, Issue.class);
        Issue newIssue = issueService.createIssue(issue);
        URI createdUri = linkTo(IssueController.class).slash(newIssue.getIssueId()).toUri();
        return ResponseEntity.created(createdUri).body(issue);

    }
}
