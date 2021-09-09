package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loan.model.Loan;

@RestController
@RequestMapping("loans")
public class LoanController {

	@GetMapping("/{number}")
	public Loan getDetails(@PathVariable long number) {
		return new Loan(number,"car",500000,6021,20);
	}
	
}
