package com.affinitas.graziani.controller;

import com.affinitas.graziani.domain.Answer;
import com.affinitas.graziani.dto.AnswerDTO;
import com.affinitas.graziani.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgraz1 on 9/1/17.
 */
@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<AnswerDTO>> list(){
        List<AnswerDTO> resp = new ArrayList<AnswerDTO>();
        List<Answer> answers =  answerRepository.findAll();
        for(Answer answer:answers){
            resp.add(new AnswerDTO(answer));
        }
        return new ResponseEntity<List<AnswerDTO>>(resp, HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = "application/json")
    public ResponseEntity<AnswerDTO> create(@RequestBody AnswerDTO answerDTO) {
        if(answerDTO == null){
            return new ResponseEntity<AnswerDTO>(HttpStatus.BAD_REQUEST);
        }
        answerRepository.save(new Answer(answerDTO));
        return new ResponseEntity<AnswerDTO>(answerDTO, HttpStatus.CREATED);
    }
}
