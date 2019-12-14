package com.num6pj.watchout.issue.ui;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.num6pj.watchout.common.ErrorResponse;
import com.num6pj.watchout.issue.application.IssueService;
import com.num6pj.watchout.issue.domain.Issue;
import com.num6pj.watchout.issue.dto.IssueDto;

@RestController
public class IssueController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final IssueService issueService;
    private final IssueValidator issueValidator;
    private final ModelMapper modelMapper;

    public IssueController(IssueService issueService, IssueValidator issueValidator, ModelMapper modelMapper) {
        this.issueService = issueService;
        this.issueValidator = issueValidator;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/issue", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity createIssue(@RequestBody @Valid IssueDto issueDto,
                                      Errors errors) {
        logger.info("Create Issue");

        issueValidator.validate(issueDto, errors);
        if(errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        Issue issue = modelMapper.map(issueDto, Issue.class);
        Issue newIssue = issueService.createIssue(issue);
        URI createdUri = linkTo(IssueController.class).slash(newIssue.getIssueId()).toUri();
        return ResponseEntity.created(createdUri).body(issue);
    }

    @RequestMapping(value = "/issue/{id}", produces = MediaTypes.HAL_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getIssueById(@PathVariable Long id) {
        Optional<Issue> issue = issueService.getIssueById(id);
        ResponseEntity response = ResponseEntity.ok().body(issue);
        return response;
    }

    @GetMapping(value = "/issue", produces = MediaTypes.HAL_JSON_VALUE)
    public Object getIssueByCategory(@RequestParam(required = false) String category, @RequestParam(required = false) String title) {
        List<Issue> issues = issueService.getIssueByCategoryAndTitle(category, title);
        return issues;
    }


}
