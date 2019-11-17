package com.num6pj.watchout.security.application;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.num6pj.watchout.user.domain.UserInfo;
import com.num6pj.watchout.user.infra.UserRepository;

/**
 * 사용자 별 데이터를 로드하는 {@link UserDetailsService} 구현 클래스며
 * {@link org.springframework.security.authentication.dao.DaoAuthenticationProvider}에서 사용하는 전략
 * read-only 메서드, new data-access 을 지원
 */
@Service
public class LoginUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public LoginUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 사용자명으로 유저를 찾는다.
     *
     * 아래 방식 택일
     * example:
     * <pre>
     * UserDetails user = User.withUsername("user")
     *     .password("{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG")
     *     .roles("USER")
     *     .build();
     *
     *  UserDetails user = new User("user",
     *      "{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG",
     *      AuthorityUtils.createAuthorityList("ROLE_USER"));
     * </pre>
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = userRepository.findByUserId(username)
                                      .orElseThrow(IllegalArgumentException::new);
        return User.withUsername(user.getUserId())
            .password(user.getPassword())
            .roles("USER")
            .build();
    }
}
