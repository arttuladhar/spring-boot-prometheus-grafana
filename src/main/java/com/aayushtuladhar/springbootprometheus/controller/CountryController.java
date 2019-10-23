package com.aayushtuladhar.springbootprometheus.controller;

import com.aayushtuladhar.springbootprometheus.domain.Country;
import com.aayushtuladhar.springbootprometheus.service.CountryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class CountryController {

  private final CountryService countryService;

  @GetMapping("/countries")
  public List<Country> getAllCountries() {
    return countryService.getAllCountries();
  }

  @GetMapping("/country/{countryCode}")
  public Country getCountryByCode(@PathVariable String countryCode) {
    return countryService.getCountryByCode(countryCode);
  }

}
