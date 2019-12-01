package com.num6pj.watchout.user.application;

import com.num6pj.watchout.user.domain.UserInfo;
import com.num6pj.watchout.user.infra.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Test
    public void create() {
        UserInfo user = new UserInfo("morrisKim", "morrisKim", "kdy0573@daum.net", "passwd");
        userRepository.save(user);
    }

}
