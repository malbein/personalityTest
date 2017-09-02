package com.affinitas.graziani.domain.type;

import com.affinitas.graziani.domain.type.range.Range;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by matiasgraziani on 9/1/17.
 */
@Entity
@DiscriminatorValue("number_range")
public class NumberRange extends QuestionType {

    @JsonProperty(value = "range")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name="range")
    private Range range;

    @PrePersist
    public void addQuestionType(){
        this.setQuestionType("number_range");
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }
}
