package com.num6pj.watchout.issue.ui;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.num6pj.watchout.TestDescription;
import com.num6pj.watchout.issue.application.IssueService;
import com.num6pj.watchout.issue.dto.IssueDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class IssueControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @InjectMocks
    IssueController issueController;

    @Mock
    IssueService issueService;

    @Test
    @TestDescription("정상적으로 이벤트를 생성하는 테스트")
    public void createIssue() throws Exception{
        IssueDto issueDto =  IssueDto
                            .builder()
                            .Category("test")
                            .title("test1")
//                            .writerUserId(11L)
                            .context("aihaiahasdasdsadsaddd")
                            .price(1000)
                            .issueState("진행중?").build();

        mockMvc.perform(post("/issue")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON)
                        .content(objectMapper.writeValueAsString(issueDto)))
               .andDo(print())
               .andExpect(status().isCreated())
               .andExpect( jsonPath("issueId").exists())
               .andExpect(header().exists(HttpHeaders.LOCATION))
               .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_UTF8_VALUE))
               .andExpect(jsonPath("createdDate").value(Matchers.not("")));

    }

    @Test
    @TestDescription("context사이즈가 10글자미 ")
    public void createEvent_Bad_request() throws Exception {

        IssueDto issueDto = IssueDto
                .builder()
                .Category("test")
                .title("aaa")
                .context("")
                .price(1000)
                .issueState("진행중?").build();

        mockMvc.perform(post("/issue")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .accept(MediaTypes.HAL_JSON)
                                .content(objectMapper.writeValueAsString(issueDto)))
               .andDo(print())
               .andExpect(status().isBadRequest());

    }




}
