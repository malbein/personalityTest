package com.affinitas.graziani.util;

import com.affinitas.graziani.Application;
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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by matiasgraziani on 9/1/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles("test")
public abstract class BaseTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    public QuestionRepository questionRepository;

    protected MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        initJsonToModel();
    }

    protected ObjectMapper objectMapper = new ObjectMapper();

    public void initJsonToModel() throws Exception{
        ClassPathResource cpr = new ClassPathResource("question.json");
        if(cpr.exists()){
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Question.class);
            List<Question> questions = objectMapper.readValue(cpr.getInputStream(),type);
            questionRepository.save(questions);
        }
    }
}
