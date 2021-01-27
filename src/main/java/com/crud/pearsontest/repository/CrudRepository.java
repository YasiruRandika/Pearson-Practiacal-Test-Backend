package com.crud.pearsontest.repository;

import com.crud.pearsontest.model.CountryModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository extends JpaRepository<CountryModel, Integer>{
    
}
