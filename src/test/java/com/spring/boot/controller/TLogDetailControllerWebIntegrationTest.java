package com.spring.boot.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Creation of spring-boot-demo-1.
 * <p/>
 * Created by tttrinh
 * Created date 3/3/17 3:29 PM
 * <p/>
 * $Revision:  $ $Date:  $
 * $Log: ,v $
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TLogDetailControllerWebIntegrationTest {
  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void testGet() throws Exception {
    ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/tlog-detail", String.class, 21);
    assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));

    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode responseJson = objectMapper.readTree(responseEntity.getBody());

    assertThat(responseJson.isMissingNode(), is(false));
    System.out.println(responseJson.toString());
//    assertThat(responseJson.toString(), equalTo("[]"));
  }
}