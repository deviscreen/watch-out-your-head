package com.num6pj.watchout.comment.domain;

import com.num6pj.watchout.issue.domain.Issue;
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

    private String context;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ISSUE_ID")
    private Issue issue;
    private long commentUserId;
    private boolean adoptedStatus;
    private Timestamp adoptedTimestamp;
    private long satisfyRate;//만족도 평가

    public Comment(Issue issue, String context, Long commentUserId) {
        this.issue = issue;
        this.context = context;
        this.commentUserId = commentUserId;
    }


}
