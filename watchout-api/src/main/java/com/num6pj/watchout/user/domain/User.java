package com.num6pj.watchout.user.domain;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name="User")
public class User {
    /*
    * TODO
    *  1. Email Validation, Phone Validation 을 위해 객체로 수정
    *
    */
    @Id @GeneratedValue
    private long userId;//
    private String name;
    private String email;
    private String contact;
    private long point;
    private String expertCategory; //전문분야
    private int careerNum; //경력
    private long reliability; //신뢰도


    public User(long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
}
