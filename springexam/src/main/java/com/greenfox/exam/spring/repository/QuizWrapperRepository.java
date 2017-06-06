package com.greenfox.exam.spring.repository;

import com.greenfox.exam.spring.model.QuizWrapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizWrapperRepository extends CrudRepository<QuizWrapper, Long> {

}
