package com.affinitas.graziani.domain;

import com.affinitas.graziani.dto.AnswerDTO;

import javax.persistence.*;

/**
 * Created by mgraz1 on 9/1/17.
 */
@Entity
public class Answer {

    public Answer(){

    }

    public Answer(AnswerDTO answerDTO){
        this.answer = answerDTO.getAnswer();
        Question question = new Question();
        question.setId(answerDTO.getQuestion());
        this.question = question;
        this.user = answerDTO.getUser();
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="question_id", nullable=false)
    private Question question;

    private String answer;

    private String user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
