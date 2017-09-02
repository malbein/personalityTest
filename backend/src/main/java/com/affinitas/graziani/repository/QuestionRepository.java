package com.affinitas.graziani.repository;

import com.affinitas.graziani.domain.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by matiasgraziani on 9/1/17.
 */
@Repository
public interface QuestionRepository  extends CrudRepository<Question, Long> {
    List<Question> findByChild(boolean child);

    @Query("select distinct (q.category) from Question q")
    List<String> findCategories();
}
