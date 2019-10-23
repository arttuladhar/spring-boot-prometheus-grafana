package com.aayushtuladhar.springbootprometheus.repository;

import com.aayushtuladhar.springbootprometheus.domain.Country;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.MeterRegistry;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class CountryRepository {

  final MeterRegistry meterRegistry;

  public CountryRepository(MeterRegistry meterRegistry) {
    this.meterRegistry = meterRegistry;
  }

  public List<Country> getAll() {

    /*
    Gauge

    * A gauge is a handle to get the current value
    * Gauges are useful for monitoring things with natural upper bounds

    */
    meterRegistry.gauge("repository.getAll", Thread.activeCount());
    return getCountriesFromFile();
  }

  public Country getCountryByCode(String countryCode) {
    long startTime = System.currentTimeMillis();
    List<Country> countryList = getCountriesFromFile();
    Country result = countryList
        .stream()
        .filter(it -> it.getCode().equals(countryCode))
        .collect(Collectors.toList()).get(0);

    long endTime = System.currentTimeMillis();
    meterRegistry.timer("repository.getCountryByCode").record(Duration.ofMillis(endTime - startTime));
    return result;
  }

  private List<Country> getCountriesFromFile() {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("countries.json").getFile());

    try {
      return new ObjectMapper().readValue(file, new TypeReference<List<Country>>() {
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
    return Collections.emptyList();
  }
}
