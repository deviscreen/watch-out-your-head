package com.num6pj.watchout.security.application;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * {@link UserDetailsService} 의해 검색된 핵심 사용자 정보 Model을 사용하기 위해 사용
 * {@link User} 의 서브 클래스
 */
public class LoginUserDetails extends User {

    public LoginUserDetails(String username, String password,
                            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public LoginUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
                            boolean credentialsNonExpired, boolean accountNonLocked,
                            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
              authorities);
    }
}
