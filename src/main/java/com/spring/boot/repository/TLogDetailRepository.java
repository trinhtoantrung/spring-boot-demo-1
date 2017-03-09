package com.spring.boot.repository;

import com.spring.boot.model.TLogDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Creation of spring-boot-demo-1.
 * <p/>
 * Created by tttrinh
 * Created date 3/2/17 5:42 PM
 * <p/>
 * $Revision:  $ $Date:  $
 * $Log: ,v $
 */

@Repository
public interface TLogDetailRepository extends JpaRepository<TLogDetail, Long>{
  List<TLogDetail> findByErreurLike(String erreurString);

  @Query("select log from TLogDetail log where log.erreur like :message")
  List<TLogDetail> queryByErreur(@Param("message") String message);

  @Query("select log from TLogDetail log where log.id = ?1")
  TLogDetail queryById(Long id);

  TLogDetail findByIdNativeSQL(Long id);

  @Query("select log from TLogDetail log where log.erreur like :message and id is not null")
  Page<TLogDetail> queryByErrorPaging(@Param("message") String message, Pageable page);
}
