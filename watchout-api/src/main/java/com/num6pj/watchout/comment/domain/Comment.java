package com.num6pj.watchout.comment.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private long satisfyRate;//만족도 평가
    private String context;
    private boolean adoptedStatus;
    private Timestamp adoptedTimestamp;
    private long commentUserId;

}
