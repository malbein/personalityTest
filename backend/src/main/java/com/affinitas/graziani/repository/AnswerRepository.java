package com.affinitas.graziani.repository;

import com.affinitas.graziani.domain.Answer;
import com.affinitas.graziani.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mgraz1 on 9/1/17.
 */
@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
