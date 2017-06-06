package com.greenfox.exam.spring;

import com.greenfox.exam.spring.model.QuestionAndAnswer;
import com.greenfox.exam.spring.repository.QuestionAndAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringexamApplication implements CommandLineRunner {

  @Autowired
  private QuestionAndAnswerRepository questionAnswerRepo;

  public static void main(String[] args) {
    SpringApplication.run(SpringexamApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    if (questionAnswerRepo.count() == 0) {
      addDefaultQuestions();
    }
  }

  private void addDefaultQuestions() {
    questionAnswerRepo.save(
            QuestionAndAnswer.builder()
                    .question("What is the color code of Green Fox?")
                    .answer("#3CB879")
                    .build());
    questionAnswerRepo.save(
            QuestionAndAnswer.builder()
                    .question("When was Green Fox founded?(yyyy.mm.)")
                    .answer("2015.09.")
                    .build());
    questionAnswerRepo.save(
            QuestionAndAnswer.builder()
                    .question("When did your course start? (yyyy.mm.dd)")
                    .answer("2017.03.13")
                    .build());
    questionAnswerRepo.save(
            QuestionAndAnswer.builder()
                    .question("What type of dog Barbi has?")
                    .answer("Whippet")
                    .build());
    questionAnswerRepo.save(
            QuestionAndAnswer.builder()
                    .question("What is HerrNorbert's favourite color?")
                    .answer("Green")
                    .build());
    questionAnswerRepo.save(
            QuestionAndAnswer.builder()
                    .question("How many classes are learning at Green Fox Academy at this moment?")
                    .answer("4")
                    .build());
    questionAnswerRepo.save(
            QuestionAndAnswer.builder()
                    .question("How many mentors teach at Green Fox at this moment?")
                    .answer("16")
                    .build());
    questionAnswerRepo.save(
            QuestionAndAnswer.builder()
                    .question("What was the name of the first Green Fox class?")
                    .answer("Vulpes")
                    .build());
    questionAnswerRepo.save(
            QuestionAndAnswer.builder()
                    .question("How many likes do we have on facebook? (~nn00)")
                    .answer("~3300")
                    .build());
    questionAnswerRepo.save(
            QuestionAndAnswer.builder()
                    .question("What is Tojas's horoscope?")
                    .answer("Libra")
                    .build());
  }
}
