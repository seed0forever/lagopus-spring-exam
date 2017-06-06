package com.greenfox.exam.spring.service;

import com.greenfox.exam.spring.model.QuizWrapper;
import com.greenfox.exam.spring.repository.QuizWrapperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizWrapperService {

  private final QuizWrapperRepository quizWrapperRepository;

  @Autowired
  public QuizWrapperService(
          QuizWrapperRepository quizWrapperRepository) {
    this.quizWrapperRepository = quizWrapperRepository;
  }

  public void save(QuizWrapper quizWrapper) {
    quizWrapperRepository.save(quizWrapper);
  }
}
