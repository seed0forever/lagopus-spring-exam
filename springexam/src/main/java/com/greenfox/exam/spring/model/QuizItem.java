package com.greenfox.exam.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizItem {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String question;
  private String answer;
}
