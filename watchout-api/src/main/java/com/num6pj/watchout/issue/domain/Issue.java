package com.num6pj.watchout.issue.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
@Data
@Entity
@Table(name="Issue")
public class Issue {

    @Id @GeneratedValue
    private long issueId;
    long writerUserId;
    private String Category;
    private Timestamp createdat;
    private String title;
    private String context;
    private long price;
    private String issueState;

}
