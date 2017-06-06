package com.greenfox.exam.spring.repository;

import com.greenfox.exam.spring.model.QuizItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizItemRepository extends CrudRepository<QuizItem, Long> {

}
