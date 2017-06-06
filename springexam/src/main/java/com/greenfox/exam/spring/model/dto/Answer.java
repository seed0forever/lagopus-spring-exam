package com.greenfox.exam.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer implements RestMessageDto {

  private long id;
  private String answer;

}
