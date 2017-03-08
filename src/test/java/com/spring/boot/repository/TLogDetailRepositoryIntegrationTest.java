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
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;

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
    System.out.println(list.size());
    assertThat(list.size(), is(greaterThanOrEqualTo(0)));
  }

  @Test
  public void testCreateNewLog() throws Exception {
    TLogDetail newTLogDetail = new TLogDetail();
    newTLogDetail.setErreur("jpa repository message test");

    newTLogDetail = tLogDetailRepository.saveAndFlush(newTLogDetail);
    System.out.println(newTLogDetail.getId() + " - " + newTLogDetail.getErreur());
    assertNotNull(newTLogDetail.getId());
  }

  @Test
  public void testFindByErreurLike() throws Exception {
    List<TLogDetail> result = tLogDetailRepository.findByErreurLike("%jpa%");
    result.forEach(tLogDetail -> {
      System.out.println(tLogDetail.getId() + " - " + tLogDetail.getErreur());
    });

    assertThat(result, notNullValue());

  }

  @Test
  public void testQueryByErreur() throws Exception {
    List<TLogDetail> result = tLogDetailRepository.queryByErreur("%jpa%");
    result.forEach(tLogDetail -> {
      System.out.println(tLogDetail.getId() + " - " + tLogDetail.getErreur());
    });
    assertThat(result, notNullValue());
  }

  @Test
  public void testQueryById() throws Exception {
    TLogDetail log = tLogDetailRepository.queryById(42L);
    if (log == null) {
      assertThat(log, nullValue());
    } else {
      System.out.println(log.getId() + " - " + log.getErreur());
      assertThat(log, notNullValue());
    }
  }

  @Test
  public void testUpdateErrorByIdNativeSQL() throws Exception {
    TLogDetail updatedLog = tLogDetailRepository.findByIdNativeSQL(42L);
    System.out.println(updatedLog.getId() + " - " + updatedLog.getErreur());
    assertThat(updatedLog, notNullValue());
  }
}