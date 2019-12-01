package com.num6pj.watchout.user.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.num6pj.watchout.common.ErrorCode;
import com.num6pj.watchout.common.ErrorResponse;
import com.num6pj.watchout.security.domain.AuthenticationRequest;
import com.num6pj.watchout.user.application.UserService;
import com.num6pj.watchout.user.domain.UserInfo;
import com.num6pj.watchout.user.ui.vo.UserRequest;

@RestController
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    /**
     * 회원 가입
     * @param user 회원가입할 유저정보
     * @throws Exception
     */
    @PostMapping("/user/join")
    public void join(@RequestBody @Valid UserRequest user) {
        //패스워드가 일치하지 않을 시
        if(!user.getPassword().equals(user.getConfirmPassword())) {
            throw new IllegalArgumentException(
                    user.getPassword() + ", " + user.getConfirmPassword() +
                    " 두 개의 패스워드가 일치하지 않습니다.");
        }
        userService.join(new ModelMapper().map(user, UserInfo.class));
    }



    /**
     * 인증이 성공했을 시에 인증 결과를 반환한 {@link Authentication} 를
     *  {@link SecurityContextHolder#setAuthentication(authentication)}
     *  현재 인증 된 보안 주체를 변경하거나, 추가한 후에,
     *  {@link HttpSession} 에 {@link #SPRING_SECURITY_CONTEXT_KEY}에 {@link SecurityContext} 정보를 추가한다.
     *
     * 인증되어 진 후에, {@link Authentication#getPrincipal()} Annotation 을 호출 하면
     * Custom 한 LoginUserDetails 에 객체를 반환해서 처리할 수 있다.
     * example:
     * <code>
     * methodA(@AuthenticationPrincipal LoginUserDetails userDetails)
     * </code>
     * exceptions:
     * <ul>
     * <li> {@link DisabledException}  계정이 비활성화 될 경우,
     * <li> {@link LockedException} 계정이 잠겨있을 경우,
     * <li> {@link BadCredentialsException} 잘못된 자격 증명
     * @param data 인증 요청 정보
     * @param session
     * @return ResponseEntity 의 응답 결과
     */
    @PostMapping("/user/login")
    public ResponseEntity<Object> login(@RequestBody AuthenticationRequest data,
                                        HttpSession session) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            data.getUsername(), data.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                                 SecurityContextHolder.getContext());
            return ResponseEntity.ok("login success");
        } catch (LockedException | BadCredentialsException | DisabledException e) {
            final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


}
