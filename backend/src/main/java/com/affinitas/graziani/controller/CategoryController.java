package com.affinitas.graziani.controller;

import com.affinitas.graziani.domain.Question;
import com.affinitas.graziani.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by matiasgraziani on 9/1/17.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<String>> list(){
        List<String> list = questionRepository.findCategories();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }
}
