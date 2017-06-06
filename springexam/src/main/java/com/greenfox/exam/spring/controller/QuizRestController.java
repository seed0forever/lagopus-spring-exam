package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.model.QuizWrapper;
import com.greenfox.exam.spring.service.QuizWrapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizRestController {

  private final QuizWrapperService quizWrapperService;

  @Autowired
  public QuizRestController(
          QuizWrapperService quizWrapperService) {
    this.quizWrapperService = quizWrapperService;
  }

  @GetMapping("/questions")
  public QuizWrapper showQuestions() {

    QuizWrapper quizWrapper = new QuizWrapper();
    quizWrapperService.save(quizWrapper);

    return quizWrapper;
  }
}
