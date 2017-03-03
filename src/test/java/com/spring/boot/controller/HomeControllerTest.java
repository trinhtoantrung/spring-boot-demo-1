package com.spring.boot.controller;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Creation of spring-boot-demo-1.
 * <p/>
 * Created by tttrinh
 * Created date 3/3/17 11:29 AM
 * <p/>
 * $Revision:  $ $Date:  $
 * $Log: ,v $
 */
public class HomeControllerTest {
  @Test
  public void testHome() throws Exception {
    HomeController controller = new HomeController();
    String expectedResult = "Demo project for spring boot";
    String result = controller.home();
    assertEquals(expectedResult, result);
  }

}