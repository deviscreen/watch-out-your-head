package com.num6pj.watchout.user.ui.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRequest {
    private String userId;
    private String email;
    private String confirmPassword;
    private String password;
    private String name;
    private String contact;
    private String expertCategory; //전문분야
    private int careerNum; //경력
    private long reliability; //신뢰도

}
