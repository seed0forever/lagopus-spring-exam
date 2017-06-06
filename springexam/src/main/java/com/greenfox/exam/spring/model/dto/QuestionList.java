package com.greenfox.exam.spring.model.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class QuestionList implements RestMessageDto {

  private long id;
  private List<Question> questions;

  public QuestionList() {
    this.questions = new ArrayList<>();
  }

  public QuestionList(List<Question> questions) {
    this.questions = questions;
  }

  public void addQuestion(Question question) {
    if (question != null) {
      questions.add(question);
    }
  }

  public long count() {
    if (questions == null) {
      return 0L;
    }
    return questions.size();
  }

  public boolean contains(Question question) {
    if (question == null) {
      return false;
    }
    if (questions == null) {
      return false;
    }
    return questions.contains(question);
  }
}
