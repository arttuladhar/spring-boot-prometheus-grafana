package com.aayushtuladhar.springbootprometheus.service;

import com.aayushtuladhar.springbootprometheus.domain.Country;
import com.aayushtuladhar.springbootprometheus.repository.CountryRepository;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

  private final CountryRepository countryRepository;
  private final MeterRegistry meterRegistry;

  public CountryService(CountryRepository countryRepository, MeterRegistry meterRegistry) {
    this.countryRepository = countryRepository;
    this.meterRegistry = meterRegistry;
  }

  public List<Country> getAllCountries() {
    meterRegistry.counter("service.getAllCountries").increment();
    return countryRepository.getAll();
  }

  public Country getCountryByCode(String countryCode) {

    // Counters (Increment / Decrement)
    meterRegistry.counter("service.getCountryByCode").increment();
    return countryRepository.getCountryByCode(countryCode);
  }
}
