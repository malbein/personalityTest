package com.affinitas.graziani;

import com.affinitas.graziani.domain.Question;
import com.affinitas.graziani.repository.QuestionRepository;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by matiasgraziani on 8/31/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class QuestionTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private QuestionRepository questionRepository;

    protected MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testFindAll() throws Exception{
        ResultActions result = mockMvc.perform(get("/question").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());
        result.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    protected ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void initJsonToModel() throws Exception{
        ClassPathResource cpr = new ClassPathResource("question.json");
        if(cpr.exists()){
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Question.class);
            List<Question> questions = objectMapper.readValue(cpr.getInputStream(),type);
            questionRepository.save(questions);
        }
    }
}
