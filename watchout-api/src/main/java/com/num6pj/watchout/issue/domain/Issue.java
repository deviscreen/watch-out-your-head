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
    private long writerUserId;
    private String Category;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private Timestamp closeDate;
    private String title;
    private String context;
    private long price;
    private String issueState;
    //TODO issueState, Category부분 코드값으로 수정 < Category는 따로 aggregation을 분리하는것도 고려 해봐야함 > 
}
