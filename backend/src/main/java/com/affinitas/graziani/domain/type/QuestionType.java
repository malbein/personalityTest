package com.affinitas.graziani.domain.type;

import com.affinitas.graziani.domain.Question;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by matiasgraziani on 9/1/17.
 */
@Entity
@DiscriminatorColumn(name="type")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public abstract class QuestionType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "type")
    @Column(name = "type", insertable = false, updatable = false)
    private String questionType;

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
