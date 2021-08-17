package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.exception.CountryNotFound;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository repository;

	@Transactional
	public List<Country> getAllCountries() {
		List<Country> countriesList = repository.findAll();
		return countriesList;
	}

	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFound {

		Optional<Country> optional = repository.findById(countryCode);
		if (!optional.isPresent()) {
			throw new CountryNotFound("Invalid Country Code");

		}
		Country country = optional.get();
		return country;
	}

	@Transactional
	public void addCountry(Country country) {
		repository.save(country);
	}

	@Transactional
	public void updateCountry(String code, String name) throws CountryNotFound {
		Optional<Country> optional = repository.findById(code);

		if (!optional.isPresent()) {
			throw new CountryNotFound("Invalid Country Code");

		}
		Country country = optional.get();
		country.setName(name);
		repository.save(country);
	}

	@Transactional
	public void deleteCountry(String code) {
		repository.deleteById(code);
	}
	
	public List<Country> getCountryContain(String str) {
		List<Country> countriesList = repository.findCountryNameContain(str);
		return countriesList;
	}

}
