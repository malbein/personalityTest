package com.affinitas.graziani.domain.type.range;

import javax.persistence.*;

/**
 * Created by matiasgraziani on 9/1/17.
 */
@Entity
public class Range {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_value")
    private Integer from;
    @Column(name = "to_value")
    private Integer to;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }
}
