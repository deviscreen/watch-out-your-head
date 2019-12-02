package com.num6pj.watchout.comment.ui;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CommentControllerTest {

    @Autowired
    MockMvc mock;


    @Test
    public void createComment() throws Exception {
        this.mock.perform(post("/comment/create")
                .contentType(MediaType.APPLICATION_JSON)
        .content("{ \"issueId\":1,\"content\":\"test\", \"commentUserId\": 20}")
        ).andExpect(status().isCreated());
    }
}