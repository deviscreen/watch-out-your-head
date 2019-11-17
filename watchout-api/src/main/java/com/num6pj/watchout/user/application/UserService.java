package com.num6pj.watchout.user.application;

import java.util.Optional;

import com.num6pj.watchout.user.domain.UserInfo;
import com.num6pj.watchout.user.infra.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService (){}

    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void create(UserInfo user){
        userRepository.save(user);
    }

    public void join(UserInfo user) {
        Optional<UserInfo> existUser = userRepository.findByUserId(user.getUserId());
        if(!existUser.isPresent()) {
            userRepository.save(new UserInfo(user.getUserId(),
                                             user.getName(),
                                             user.getEmail(),
                                             new BCryptPasswordEncoder().encode(user.getPassword())));
        }

    }
}
