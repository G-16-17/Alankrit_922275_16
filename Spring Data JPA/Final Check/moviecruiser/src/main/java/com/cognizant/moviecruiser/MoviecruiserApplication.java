package com.cognizant.moviecruiser;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;
import com.cognizant.moviecruiser.util.DateUtil;



@SpringBootApplication
public class MoviecruiserApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecruiserApplication.class);
	private static MovieService mvService;
	public static void main(String[] args) throws ParseException {
		LOGGER.info("Inside main");
		ApplicationContext context = SpringApplication.run(MoviecruiserApplication.class, args);
		mvService=context.getBean(MovieService.class);
//		testGetMovieListAdmin();
//		testGetMovieListCustomer();
//		testGetMovie();
		testEditMovie();
		LOGGER.info("---Completed---");
		

		
	}
	private static void testGetMovieListAdmin() {
		LOGGER.info("Start Movie List Admin");
		List<Movie> adminList=mvService.getMovieListAdmin();
		LOGGER.debug("Movies = {}", adminList);
		LOGGER.info("End Movie List Admin");
		
	}
	
	private static void testGetMovieListCustomer() {
		LOGGER.info("Start Movie List Customer");
		List<Movie> customerList=mvService.getMovieListCustomer();
		LOGGER.debug("Movies = {}", customerList);
		LOGGER.info("End Movie List Customer");
		
	}
	
	
	
	private static void testGetMovie() {
		LOGGER.info("Start Get Movie");
		Movie viewMovie=mvService.getMovie(1);
		LOGGER.debug("Movie = {}", viewMovie);
		LOGGER.info("End Get Movie");
	}
	
	private static void testEditMovie() throws ParseException {
		LOGGER.info("Start Edit Movie");
		Movie newMovie= new Movie(1,"Udaan",4,"Action",false,true,DateUtil.convertToDate("23/07/2008"));
		mvService.editMovie(newMovie);
		Movie retrievedMovie=mvService.getMovie(1);
		LOGGER.debug("Edited Movie = {}", retrievedMovie);
		LOGGER.info("End Edit Movie");
		
	}

}
