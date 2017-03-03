package com.spring.boot.model;

import javax.persistence.*;

/**
 * Creation of spring-boot-demo-1.
 * <p/>
 * Created by tttrinh
 * Created date 3/2/17 5:26 PM
 * <p/>
 * $Revision:  $ $Date:  $
 * $Log: ,v $
 */

@Entity
@Table(name = "t_logdtl")
public class TLogDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;

  String erreur;

  public TLogDetail() {
  }

  public TLogDetail(Long id, String erreur) {
    this.id = id;
    this.erreur = erreur;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getErreur() {
    return erreur;
  }

  public void setErreur(String erreur) {
    this.erreur = erreur;
  }
}
