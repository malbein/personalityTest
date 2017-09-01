package com.affinitas.graziani.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by matiasgraziani on 8/31/17.
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    @GetMapping(produces = "application/json")
    public ResponseEntity<Map<String,String>> list(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("status","works");
        return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
    }
}
