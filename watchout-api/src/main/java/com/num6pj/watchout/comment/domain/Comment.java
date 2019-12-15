package com.num6pj.watchout.comment.domain;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="Comment")
public class Comment {
    @Id
    @GeneratedValue
    private long CommentId;

    private Timestamp createAt;
    private long issueId;
    private String context;
    private long commentUserId;
    private boolean adoptedStatus;
    private Timestamp adoptedTimestamp;
    private long satisfyRate;//만족도 평가

    public Comment(Long issueId, String context, Long commentUserId) {
        this.issueId = issueId;
        this.context = context;
        this.commentUserId = commentUserId;
    }


}
