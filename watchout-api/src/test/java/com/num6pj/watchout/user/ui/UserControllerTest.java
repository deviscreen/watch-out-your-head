package com.num6pj.watchout.user.ui;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.num6pj.watchout.security.domain.AuthenticationRequest;
import com.num6pj.watchout.user.domain.UserInfo;
import com.num6pj.watchout.user.infra.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void init() {
        when(userRepository.findByUserId("user"))
                .thenReturn(Optional.of(
                        new UserInfo(
                                "user",
                                "test",
                                "n@n.m",
                                new BCryptPasswordEncoder().encode("password"))));
    }

    @Test
    public void loginWithValidUserThenAuthenticated() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
            .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                new AuthenticationRequest("user", "password"))))
               .andDo(print())
               .andExpect(authenticated().withUsername("user"));
    }

    @Test
    public void loginWithInvalidUserThenUnauthenticated() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(
                      new AuthenticationRequest("invalid", "invalidpassword"))))
               .andDo(print())
               .andExpect(unauthenticated());
    }
}
