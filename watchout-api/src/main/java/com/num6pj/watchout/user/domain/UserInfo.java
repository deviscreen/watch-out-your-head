package com.num6pj.watchout.user.domain;

import java.time.LocalDateTime;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name="user")
public class UserInfo {
    /*
     * TODO
     *  1. Email Validation, Phone Validation 을 위해 객체로 수정
     *
     */
    @Id
    private String userId;
    private String password;
    private String name;
    private String email;
    private String contact;
    private long point;
    private String expertCategory; //전문분야
    private int careerNum; //경력
    private long reliability; //신뢰도
    private LocalDateTime createTime; //생성 시간

    private UserInfo() {}

    public UserInfo(String userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createTime = LocalDateTime.now();
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
