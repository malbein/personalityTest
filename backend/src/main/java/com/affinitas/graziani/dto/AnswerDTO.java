package com.affinitas.graziani.dto;

import com.affinitas.graziani.domain.Answer;
import com.affinitas.graziani.domain.Question;

/**
 * Created by mgraz1 on 9/1/17.
 */
public class AnswerDTO {

    public AnswerDTO(){

    }

    public AnswerDTO(Answer answer){
        this.question = answer.getQuestion().getId();
        this.answer = answer.getAnswer();
    }

    private Long question;

    private String answer;

    public Long getQuestion() {
        return question;
    }

    public void setQuestion(Long question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
