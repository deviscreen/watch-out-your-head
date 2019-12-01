package com.num6pj.watchout.manager.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table
@Getter
public class Category {
    @Id
    @GeneratedValue
    private Long id; //ID
    private Long resourceId; //리소스 ID
    private String name; //카테고리 명
    private LocalDateTime createTime; //생성 시간
    private LocalDateTime changeTime; //변경 시간

    private Category() {}

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
        this.createTime = LocalDateTime.now();
        this.changeTime = LocalDateTime.now();
    }

    public Category(String name, Long resourceId) {
        this.name = name;
        this.resourceId = resourceId;
        this.createTime = LocalDateTime.now();
        this.changeTime = LocalDateTime.now();
    }
}
