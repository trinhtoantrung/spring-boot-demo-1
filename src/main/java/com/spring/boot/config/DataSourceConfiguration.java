package com.spring.boot.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Creation of spring-boot-demo-1.
 * <p/>
 * Created by tttrinh
 * Created date 3/2/17 2:47 PM
 * <p/>
 * $Revision:  $ $Date:  $
 * $Log: ,v $
 */

@Configuration
public class DataSourceConfiguration {

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  @Primary
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }
}
