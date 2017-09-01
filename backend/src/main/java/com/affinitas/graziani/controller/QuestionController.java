package com.affinitas.graziani.controller;

import com.affinitas.graziani.domain.Question;
import com.affinitas.graziani.domain.type.predicate.Condition;
import com.affinitas.graziani.repository.QuestionRepository;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by matiasgraziani on 8/31/17.
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    protected ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(produces = "application/json")
    public ResponseEntity<Iterable<Question>> list(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("status","works");
        Iterable<Question> list = questionRepository.findByChild(false);
        return new ResponseEntity<Iterable<Question>>(list, HttpStatus.OK);
    }

    @GetMapping(path = "/init", produces = "application/json")
    public ResponseEntity<Void> initialize() throws Exception{
        ClassPathResource cpr = new ClassPathResource("question.json");
        if(cpr.exists()){
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Question.class);
            List<Question> questions = objectMapper.readValue(cpr.getInputStream(),type);
            questionRepository.save(questions);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
