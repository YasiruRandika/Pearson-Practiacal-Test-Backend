package com.crud.pearsontest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.crud.pearsontest.model.CountryModel;
import com.crud.pearsontest.service.CountryService;

@RestController
public class CountryController {
    //Inject CountryService for  CountryController
    @Autowired
    CountryService countryService;

    @CrossOrigin(origins = "https://pearsontest-90825.web.app")
    @GetMapping("/getCountryList")
    public List<CountryModel> getCountryList() {
        List<CountryModel> countryList = new ArrayList<>();
        countryList = countryService.getCountryList();
        return countryList;
    }

    @CrossOrigin(origins = "https://pearsontest-90825.web.app")
    @PostMapping("/addCountry")
    public CountryModel addCountry(@RequestBody CountryModel country) {
        CountryModel countryModel = countryService.addCountry(country);
        return countryModel;
    }

    @CrossOrigin(origins = "https://pearsontest-90825.web.app")
    @GetMapping("/getCountryById/{id}")
    public Optional<CountryModel> getCountryById(@PathVariable int id) {
        return countryService.getCountryById(id);
    }

    @CrossOrigin(origins = "https://pearsontest-90825.web.app")
    @DeleteMapping("/deleteCountry/{id}")
    public String deleteCountry(@PathVariable int id) {
        return countryService.deleteCountry(id);
    }

    @CrossOrigin(origins = "https://pearsontest-90825.web.app")
    @PutMapping("/updateCountry/{id}")
    public CountryModel updateCountry(@RequestBody CountryModel country) {
		return countryService.updateCountry(country);
	}
}
