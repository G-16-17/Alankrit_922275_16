package com.cognizant.moviecruiser.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.moviecruiser.model.Favorites;

public interface FavRepository extends JpaRepository<Favorites, Map<Integer, Integer>>{

}
