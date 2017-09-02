package com.affinitas.graziani.domain.type;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import java.util.List;

/**
 * Created by matiasgraziani on 9/1/17.
 */
@Entity
@DiscriminatorValue("single_choice")
public class SingleChoice extends QuestionType {

    @PrePersist
    public void addQuestionType(){
        this.setQuestionType("single_choice");
    }

    @ElementCollection(targetClass=String.class)
    private List<String> options;

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
