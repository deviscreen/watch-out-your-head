package com.num6pj.watchout.manager.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;

@Entity
@Table(name = "watchout_resource",
uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id", "path"})
})
@Getter
public class ResourceInfo {
    @Id
    @GeneratedValue
    private Long id;
    private String name; //리소스
    private String path;
    private String description; // 설명
    private LocalDateTime createTime; //생성 시간
    private LocalDateTime changeTime; //변경 시간

    private ResourceInfo() {}

    public ResourceInfo(String name) {
        this.name = name;
    }

    public ResourceInfo(String name, String path, String description) {
        this.name = name;
        this.path = path;
        this.description = description;
        this.createTime = LocalDateTime.now();
        this.changeTime = LocalDateTime.now();
    }

    public ResourceInfo(Long id, String name, String path, String description) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.description = description;
        this.changeTime = LocalDateTime.now();
    }
}
