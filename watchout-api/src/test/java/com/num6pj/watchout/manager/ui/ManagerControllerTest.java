package com.num6pj.watchout.manager.ui;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.num6pj.watchout.manager.infra.ResourceRepository;
import com.num6pj.watchout.manager.ui.vo.CategoryRequest;
import com.num6pj.watchout.manager.ui.vo.ResourceRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ManagerControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ResourceRepository resourceRepository;

    @Ignore
    @Test
    public void createResource() throws Exception {
        ResourceRequest resource = ResourceRequest.builder().name("test")
                                                  .path("/").desc("test").build();
        mvc.perform(MockMvcRequestBuilders.post("/resource/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(resource)))
            .andDo(print())
            .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createCategoryShouldReturn200() throws Exception {
        CategoryRequest category = CategoryRequest.builder().categoryName("test")
                                                  .resourceName("test").build();
        mvc.perform(MockMvcRequestBuilders.post("/category/create")
                                          .contentType(MediaType.APPLICATION_JSON)
                                          .content(objectMapper.writeValueAsString(category)))
           .andDo(print())
           .andExpect(status().is2xxSuccessful());
    }

    /**
     * @todo IllegalArgumentException 일 경우, 400 Error 처리 되게 수정
     */
    @Ignore
    @Test
    public void createCategoryShouldReturn400() throws Exception {
        CategoryRequest category = CategoryRequest.builder().categoryName("test")
                                                  .resourceName("test").build();
        mvc.perform(MockMvcRequestBuilders.post("/category/create")
               .contentType(MediaType.APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(category)))
               .andDo(print())
               .andExpect(status().isBadRequest());
    }

    @Test
    public void changeCategoryShouldReturn200() throws Exception {
        CategoryRequest category = CategoryRequest.builder().categoryName("test")
                                                  .resourceName("test2").build();
        mvc.perform(MockMvcRequestBuilders.post("/category/change")
                                          .contentType(MediaType.APPLICATION_JSON)
                                          .content(objectMapper.writeValueAsString(category)))
           .andDo(print())
           .andExpect(status().is2xxSuccessful());
    }
}
