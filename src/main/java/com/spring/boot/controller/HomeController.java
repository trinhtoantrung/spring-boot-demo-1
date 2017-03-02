package com.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Creation of spring-boot-demo-1.
 * <p/>
 * Created by tttrinh
 * Created date 3/1/17 10:38 AM
 * <p/>
 * $Revision:  $ $Date:  $
 * $Log: ,v $
 */

@RestController
public class HomeController {
  @RequestMapping("/")
  public String home() {
    return "Demo project for spring boot";
  }
}
