package com.num6pj.watchout.user.application;

import com.num6pj.watchout.user.domain.User;
import com.num6pj.watchout.user.infra.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Test
    public void createUser() {
        User user = new User(1L,"morrisKim","kdy0573@daum.net");
        userRepository.save(user);
    }

}
