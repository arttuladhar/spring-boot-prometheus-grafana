package com.aayushtuladhar.springbootprometheus.repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.springframework.stereotype.Repository;

@Repository
public class TimeRepository {

  public String getFormattedTime() {
    DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z", Locale.US)
        .withZone(ZoneId.systemDefault());
    LocalDateTime now = LocalDateTime.now();
    return simpleDateFormat.format(now);
  }

}
