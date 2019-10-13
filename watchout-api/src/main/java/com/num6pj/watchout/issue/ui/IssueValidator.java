package com.num6pj.watchout.issue.ui;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.num6pj.watchout.issue.dto.IssueDto;

@Component
public class IssueValidator {
    public void validate(IssueDto issueDto, Errors errors) {
        if(issueDto.getContext().length() < 10)  {
            errors.rejectValue("context", "WrongValue", "context length should exceed 50 characters ");
        }
    }
}
