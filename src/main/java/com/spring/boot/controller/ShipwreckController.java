package com.spring.boot.controller;

import com.spring.boot.model.Shipwreck;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Creation of spring-boot-demo-1.
 * <p/>
 * Created by tttrinh
 * Created date 3/1/17 4:36 PM
 * <p/>
 * $Revision:  $ $Date:  $
 * $Log: ,v $
 */

@RestController
@RequestMapping("/api/v1/")
public class ShipwreckController {

  @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
  public List<Shipwreck> list() {
    return ShipwreckStub.list();
  }

  @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
  public Shipwreck create(@RequestBody Shipwreck shipwreck) {
    return ShipwreckStub.create(shipwreck);
  }

  @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
  public Shipwreck get(@PathVariable Long id) {
    return ShipwreckStub.get(id);
  }

  @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
  public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
    return ShipwreckStub.update(id, shipwreck);
  }

  @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
  public Shipwreck delele(@PathVariable Long id) {
    return ShipwreckStub.delete(id);
  }
}
