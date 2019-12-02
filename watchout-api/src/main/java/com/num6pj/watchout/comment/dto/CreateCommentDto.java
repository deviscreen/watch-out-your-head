package com.num6pj.watchout.comment.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateCommentDto {
    Long issueId;
    String context;
    Long commentUserId;
}
