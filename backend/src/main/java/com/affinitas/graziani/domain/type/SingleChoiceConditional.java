package com.affinitas.graziani.domain.type;

import com.affinitas.graziani.domain.type.predicate.Condition;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

/**
 * Created by matiasgraziani on 9/1/17.
 */
@Entity
@DiscriminatorValue("single_choice_conditional")
public class SingleChoiceConditional extends QuestionType{

    @ElementCollection(targetClass=String.class)
    private List<String> options;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name="condition")
    private Condition condition;

    @PrePersist
    public void addQuestionType(){
        this.setQuestionType("single_choice_conditional");
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
