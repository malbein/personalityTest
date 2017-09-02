package com.affinitas.graziani.domain.type.predicate;

import com.affinitas.graziani.domain.Question;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by matiasgraziani on 9/1/17.
 */
@Entity
public class Condition {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "if_positive")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name="question_id", nullable=false)
    private Question ifPositive;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name="predicate_id", nullable=false)
    private Predicate predicate;

    public Question getIfPositive() {
        return ifPositive;
    }

    public void setIfPositive(Question ifPositive) {
        ifPositive.setChild(true);
        this.ifPositive = ifPositive;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
