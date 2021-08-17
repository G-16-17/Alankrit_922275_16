package com.cognizant.moviecruiser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.repository.FavRepository;



@Service
public class FavService {
		
		@Autowired
		private FavRepository favRepository;

}
