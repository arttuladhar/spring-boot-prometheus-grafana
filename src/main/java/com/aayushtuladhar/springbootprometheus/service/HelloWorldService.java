package com.aayushtuladhar.springbootprometheus.service;

import com.aayushtuladhar.springbootprometheus.domain.HelloResult;
import com.aayushtuladhar.springbootprometheus.repository.TimeRepository;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

  private final TimeRepository timeRepository;

  public HelloWorldService(TimeRepository timeRepository) {
    this.timeRepository = timeRepository;
  }

  public HelloResult getInfo() {
    String date = timeRepository.getFormattedTime();
    return new HelloResult("hello world!", date);
  }

}