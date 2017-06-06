package com.greenfox.exam.spring.model.dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AnswerList implements RestMessageDto {

  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private List<Answer> answers;

  public AnswerList() {
    this.answers = new ArrayList<>();
  }

  public AnswerList(List<Answer> answers) {
    this.answers = answers;
  }

  public void addQuestion(Answer answer) {
    answers.add(answer);
  }

  public long count() {
    if (answers == null) {
      return 0L;
    }
    return answers.size();
  }
}
