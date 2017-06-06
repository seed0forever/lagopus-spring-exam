package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.model.dto.QuestionList;
import com.greenfox.exam.spring.service.QuizService;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizRestController {

  private final AtomicLong counter;
  private final QuizService quizService;

  @Autowired
  public QuizRestController(
          QuizService quizService) {
    this.counter = new AtomicLong();
    this.quizService = quizService;
  }

  @GetMapping("/questions")
  public QuestionList showNewQuestions() {
    QuestionList questionList = new QuestionList();
    questionList.setId(counter.incrementAndGet());
    quizService.fillWithRandomQuestions(5, questionList);
    return questionList;
  }
}
