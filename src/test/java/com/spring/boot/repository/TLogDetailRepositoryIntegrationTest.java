package com.spring.boot.repository;

import com.spring.boot.SpringBootDemo1Application;
import com.spring.boot.model.TLogDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

/**
 * Creation of spring-boot-demo-1.
 * <p/>
 * Created by tttrinh
 * Created date 3/3/17 2:38 PM
 * <p/>
 * $Revision:  $ $Date:  $
 * $Log: ,v $
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemo1Application.class)
public class TLogDetailRepositoryIntegrationTest {
  @Autowired
  private TLogDetailRepository tLogDetailRepository;

  @Test
  public void testFindAll() throws Exception {
    List<TLogDetail> list = tLogDetailRepository.findAll();
    assertThat(list.size(), is(greaterThanOrEqualTo(0)));
  }
}