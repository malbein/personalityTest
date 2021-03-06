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

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Question>> list(){
        List<Question> list = questionRepository.findByChild(false);
        return new ResponseEntity<List<Question>>(list, HttpStatus.OK);
    }

}
