package com.affinitas.graziani.domain.type.predicate;

import javax.persistence.*;
import java.util.List;

/**
 * Created by matiasgraziani on 9/1/17.
 */
@Entity
public class Predicate {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(targetClass=String.class)
    private List<String> exactEquals;

    public List<String> getExactEquals() {
        return exactEquals;
    }

    public void setExactEquals(List<String> exactEquals) {
        this.exactEquals = exactEquals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
