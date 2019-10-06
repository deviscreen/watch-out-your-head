package com.num6pj.watchout.user.application;

import com.num6pj.watchout.user.domain.User;
import com.num6pj.watchout.user.infra.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService (){

    }
    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(User user){
//        User user = new User(1L,"morrisKim","kdy0573@daum.net");
        userRepository.save(user);
    }

}
