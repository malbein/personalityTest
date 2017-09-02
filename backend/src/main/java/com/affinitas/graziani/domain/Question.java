package com.affinitas.graziani.domain;

import com.affinitas.graziani.domain.type.NumberRange;
import com.affinitas.graziani.domain.type.QuestionType;
import com.affinitas.graziani.domain.type.SingleChoice;
import com.affinitas.graziani.domain.type.SingleChoiceConditional;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by matiasgraziani on 9/1/17.
 */
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String question;

    private String category;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = SingleChoice.class, name = "single_choice"),
            @JsonSubTypes.Type(value = NumberRange.class, name = "number_range"),
            @JsonSubTypes.Type(value = SingleChoiceConditional.class, name = "single_choice_conditional")
    })
    @JsonProperty(value = "question_type")
    @Cascade(CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name="question_type", nullable=false)
    private QuestionType questionType;

    private boolean child = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public boolean getChild() {
        return child;
    }

    public void setChild(boolean child) {
        this.child = child;
    }
}
