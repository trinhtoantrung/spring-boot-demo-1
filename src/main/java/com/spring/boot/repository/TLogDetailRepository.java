package com.spring.boot.repository;

import com.spring.boot.model.TLogDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
}
