package com.affinitas.graziani.config;

import com.affinitas.graziani.domain.Question;
import com.affinitas.graziani.repository.QuestionRepository;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by mgraz1 on 9/2/17.
 */
@Component
@DependsOn("liquibase")
@Profile("!test")
public class Initialize {

    @Autowired
    private QuestionRepository questionRepository;

    protected ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void init() throws Exception{
        ClassPathResource cpr = new ClassPathResource("question.json");
        if(cpr.exists()){
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Question.class);
            List<Question> questions = objectMapper.readValue(cpr.getInputStream(),type);
            questionRepository.save(questions);
        }
    }
}
