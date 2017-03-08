package com.spring.boot.controller;

import com.spring.boot.model.TLogDetail;
import com.spring.boot.repository.TLogDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Creation of spring-boot-demo-1.
 * <p/>
 * Created by tttrinh
 * Created date 3/2/17 5:47 PM
 * <p/>
 * $Revision:  $ $Date:  $
 * $Log: ,v $
 */

@RestController
@RequestMapping("api/v1/")
public class TLogDetailController {

  @Autowired
  private TLogDetailRepository tLogDetailRepository;

  @RequestMapping(value = "tlog-detail/{id}", method = RequestMethod.GET)
  public TLogDetail get(@PathVariable Long id) {
    return tLogDetailRepository.findOne(id);
  }

  @RequestMapping(value = "tlog-detail/find/{errorMessage}", method = RequestMethod.GET)
  public List<TLogDetail> get(@PathVariable String errorMessage) {
    return tLogDetailRepository.findByErreurLike("%" + errorMessage + "%");
  }

  @RequestMapping(value = "tlog-detail", method = RequestMethod.POST)
  public TLogDetail create(@RequestBody TLogDetail tLogDetail) {
    return tLogDetailRepository.saveAndFlush(tLogDetail);
  }
}
