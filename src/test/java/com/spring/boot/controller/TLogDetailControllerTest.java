package com.spring.boot.controller;

import com.spring.boot.model.TLogDetail;
import com.spring.boot.repository.TLogDetailRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Creation of spring-boot-demo-1.
 * <p/>
 * Created by tttrinh
 * Created date 3/3/17 2:02 PM
 * <p/>
 * $Revision:  $ $Date:  $
 * $Log: ,v $
 */
public class TLogDetailControllerTest {
  @InjectMocks
  private TLogDetailController tLogDetailController;

  @Mock
  private TLogDetailRepository tLogDetailRepository;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGet() throws Exception {
    TLogDetail tLogDetail = new TLogDetail();
    tLogDetail.setId(21L);

    when(tLogDetailRepository.findOne(21L)).thenReturn(tLogDetail);
    TLogDetail tLogDetail1 = tLogDetailController.get(21L);
    verify(tLogDetailRepository).findOne(21L);

//    assertEquals(21L, tLogDetail1.getId().longValue());
    assertThat(tLogDetail1.getId(), is(21L));
  }

  @Test
  public void testCreate() throws Exception {

  }

}