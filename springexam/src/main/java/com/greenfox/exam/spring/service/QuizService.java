package com.greenfox.exam.spring.service;

import com.greenfox.exam.spring.model.QuizItem;
import com.greenfox.exam.spring.model.dto.Question;
import com.greenfox.exam.spring.model.dto.QuestionList;
import com.greenfox.exam.spring.repository.QuizItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

  private final QuizItemRepository quizItemRepository;

  @Autowired
  public QuizService(
          QuizItemRepository quizItemRepository) {
    this.quizItemRepository = quizItemRepository;
  }

  public void fillWithRandomQuestions(int amount, QuestionList questionList) {
    while (questionList.count() < amount) {
      Question candidateQuestion = chooseRandomQuestion();

      if (!questionList.contains(candidateQuestion)) {
        questionList.addQuestion(candidateQuestion);
      }
    }
  }

  private Question chooseRandomQuestion() {
    QuizItem chosenQuizItem = chooseRandomQuizItem();
    return Question.builder()
            .id(chosenQuizItem.getId())
            .question(chosenQuizItem.getQuestion())
            .build();
  }

  private QuizItem chooseRandomQuizItem() {
    long numberOfQuizItems = quizItemRepository.count();
    long randomIndex = generateRandomLong(numberOfQuizItems);
    return quizItemRepository.findOne(randomIndex);
  }

  private long chooseRandomQuizItemById() {
    long numberOfQuestions = quizItemRepository.count();
    long randomIndex = generateRandomLong(numberOfQuestions);
    return randomIndex;
  }

  private long generateRandomLong(long upperBoundExclusive) {
    long randomNumber = (long) (Math.random() * upperBoundExclusive);
    return randomNumber;
  }

  public long countQuestions(QuestionList questionList) {
    if (questionList == null || questionList.getQuestions() == null) {
      return 0L;
    }
    return questionList.getQuestions().size();
  }
}
