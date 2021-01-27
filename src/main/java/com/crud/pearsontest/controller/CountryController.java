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

    @GetMapping("/getCountryList")
    @CrossOrigin(origins="https://pearsontest-90825.web.app/")
    public List<CountryModel> getCountryList() {
        List<CountryModel> countryList = new ArrayList<>();
        countryList = countryService.getCountryList();
        return countryList;
    }

    @PostMapping("/addCountry")
    @CrossOrigin(origins="https://pearsontest-90825.web.app/")
    public CountryModel addCountry(@RequestBody CountryModel country) {
        CountryModel countryModel = countryService.addCountry(country);
        return countryModel;
    }

    @GetMapping("/getCountryById/{id}")
    @CrossOrigin(origins="https://pearsontest-90825.web.app/")
    public Optional<CountryModel> getCountryById(@PathVariable int id) {
        return countryService.getCountryById(id);
    }

    @DeleteMapping("/deleteCountry/{id}")
    @CrossOrigin(origins="https://pearsontest-90825.web.app/")
    public String deleteCountry(@PathVariable int id) {
        return countryService.deleteCountry(id);
    }

    @PutMapping("/updateCountry/{id}")
    @CrossOrigin(origins="https://pearsontest-90825.web.app/")
    public CountryModel updateCountry(@RequestBody CountryModel country) {
		return countryService.updateCountry(country);
	}
}
