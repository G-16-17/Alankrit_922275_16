package com.cognizant.ormlearn.exception;

public class CountryNotFound extends Exception {

	public CountryNotFound() {
		// TODO Auto-generated constructor stub
	}

	public CountryNotFound(String msg) {
		super(msg);
	}

	public CountryNotFound(Throwable cause) {
		super(cause);

	}

	public CountryNotFound(String message, Throwable cause) {
		super(message, cause);

	}
}
