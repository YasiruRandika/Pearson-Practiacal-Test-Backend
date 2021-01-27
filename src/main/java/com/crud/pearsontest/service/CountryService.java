package com.crud.pearsontest.service;

import java.util.List;
import java.util.Optional;

import com.crud.pearsontest.model.CountryModel;
import com.crud.pearsontest.repository.CrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    //Inject CrudRepository to Country Service
    @Autowired
    private CrudRepository repository;

    /*
    Returns the list of countries in the database
    If there are no entries in the database it will return an empty array
    @params -
    @return List<CountryModel>
     */
    public List<CountryModel> getCountryList() {
        return repository.findAll();
    }

    /*
    Add country to the in-memory database h2
    @params country includes the varibles of the CountryModel
    @return CountryModel
     */
    public CountryModel addCountry(CountryModel country) {
        return repository.save(country);
    }

    /*
    Returns Country according to the requested id
    @params id Id of the record | primary key of that table
    @return CountryModel
     */
    public Optional<CountryModel> getCountryById(int id) {
        return repository.findById(id);
    }

    /*
    Delete a country from the database with the given id
    @params id Id of the record | primary key of that table
    @return result whether the operation is sucess or not
     */
    public String deleteCountry(int id) {
        String result;
        try {
            repository.deleteById(id);
            result = "Successfully deleted the record";
        } catch (Exception e) {
            result = "Exception occured in deleting the record";
        }
        return result;
    }

    /*
    Update a country record on database
    @params country
    @return CountryModel
     */
	public CountryModel updateCountry(CountryModel country) {
		return repository.save(country);
	}
}
