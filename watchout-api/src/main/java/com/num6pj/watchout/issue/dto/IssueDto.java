package com.num6pj.watchout.issue.dto;

import java.sql.Timestamp;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueDto {

    @NotNull
    private long writerUserId;
    @NotEmpty
    private String Category;
    @NotEmpty
    private String title;
    @NotEmpty
    private String context;
    @Min(0)
    private long price;
    @NotEmpty
    private String issueState;
}
