package com.num6pj.watchout.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.num6pj.watchout.security.application.LoginUserDetailsService;

@Configuration
@EnableWebSecurity
public class MyWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * {@link WebSecurity} 지정된 특정 요청을 무시
     */
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/h2-console/**", "/resources/**");
    }

    /**
     * {@link HttpSecurity} 를 구성할려면, {@link MyWebSecurityConfiguration} 로 대체
     *
     * 기본 {@link WebSecurityConfigurerAdapter} super 클래스
     *
     * default:
     * <pre>
     * http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
     * </pre>
     */
    protected void configure(HttpSecurity http) throws Exception {
        http.headers()
            .frameOptions().sameOrigin()
            .httpStrictTransportSecurity().disable();

        http
            .csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.NEVER)
            .and()
            .authorizeRequests()
            .antMatchers("/user/join", "/user/login",
                    "/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .logout().permitAll();

    }

    /**
     * {@link #authenticationManagerBean()} 메서드를 사용하여,
     * {@link AuthenticationManager} 결과를 Bean 노출
     */
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 인증 {@link Configuration} 기능을 제공한다.
     * {@link GlobalAuthenticationConfigurerAdapter}는 {@link AuthenticationConfiguration} 설정하기 위해
     * 사용되어 진다.
     */
    @Configuration
    static class AuthenticationConfiguration
        extends GlobalAuthenticationConfigurerAdapter {

        private UserDetailsService userDetailsService;

        public AuthenticationConfiguration(LoginUserDetailsService userDetailsService) {
            this.userDetailsService = userDetailsService;
        }

        @Bean
        PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        /**
         *{@link SecurityBuilder} 는 {@link AuthenticationManager}를 만드는 데 사용되지만,
         * memory authentication, LDAP authentication, JDBC based authentication,
         * {@link UserDetailsService} 그리고 {@link AuthenticationProvider} 추가 쉽게 할 수 있으므로,
         * {@link UserDetailsService} 암호를 대조할 때, 사용되는 {@link #passwordEncoder()} 를 사용
         */
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService)
                    .passwordEncoder(passwordEncoder());
        }


    }

}
