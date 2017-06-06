package com.greenfox.exam.spring.controller;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import com.greenfox.exam.spring.SpringexamApplication;
import com.greenfox.exam.spring.service.QuizService;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringexamApplication.class)
@WebAppConfiguration
public class QuizRestControllerTest {

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
          MediaType.APPLICATION_JSON.getSubtype(),
          Charset.forName("utf8"));

  private MockMvc mockMvc;
  private HttpMessageConverter mappingJackson2HttpMessageConverter;

  @Autowired
  private WebApplicationContext webApplicationContext;

  private QuizService mealService;

  @Autowired
  void setConverters(HttpMessageConverter<?>[] converters) {

    this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
            .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
            .findAny()
            .orElse(null);

    assertNotNull("the JSON message converter must not be null",
            this.mappingJackson2HttpMessageConverter);
  }

  @Before
  public void setUp() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void showNewQuestions_hasId() throws Exception {
    mockMvc.perform(get("/questions"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(contentType))
            .andExpect(jsonPath("$").value(hasKey("id")));
  }

}