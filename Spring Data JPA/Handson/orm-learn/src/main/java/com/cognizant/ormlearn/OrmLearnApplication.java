package com.cognizant.ormlearn;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.exception.CountryNotFound;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService service;
	private static StockService stockService;
	private static StockRepository stockRepository;
	
	private static DepartmentService departmentService;
	private static EmployeeService employeeService;
	private static SkillService skillService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Application Started........");
		employeeService=context.getBean(EmployeeService.class);
		departmentService=context.getBean(DepartmentService.class);
		skillService=context.getBean(SkillService.class);
		
		testAddSkillToEmployee();
		
		
		
//		stockService=context.getBean(StockService.class);
//		List<Stock> slist=stockService.getAllStock("FB", 9, 2019);
//		LOGGER.info("Stock: {}",slist);
		
		//service = context.getBean(CountryService.class);
		//testGetCountry();
		
	}
	public static void testAddSkillToEmployee() {
		LOGGER.info("Start");
		Employee employee=employeeService.get(4);
		Set<Skill> skillList=employee.getSkillList();
		Skill skill1=skillService.get(1);
		skillList.add(skill1);
		skillList.add(skillService.get(3));
		employeeService.save(employee);
		LOGGER.info("End");
	}
	
	public static void testGetDepartment() {
		
		LOGGER.info("Start");
		Department department=departmentService.get(3);
		LOGGER.debug("Department : {} ",department);
		LOGGER.debug("EmployeeList : {} ",department.getEmployeeList());
		LOGGER.info("End");

	}
	public static void testGetEmployee() {
		
		LOGGER.info("Start");
		Employee employee=employeeService.get(2);
		LOGGER.debug("Employee : {} ",employee);
		LOGGER.debug("Department : {} ",employee.getDepartment());
		LOGGER.debug("Skill : {} ",employee.getSkillList());
		LOGGER.info("End");

	}
public static void testAddEmployee() {
		
		LOGGER.info("Start");
		Employee employee=new Employee();
		Department department=departmentService.get(1);
		employee.setName("Tom");
		employee.setSalary(new BigDecimal(15000));
		employee.setPermanent(true);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date dob=simpleDateFormat.parse("02/07/2020");
			employee.setDateOfBirth(dob);
			employee.setDepartment(department);
			employeeService.save(employee);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		LOGGER.info("End");

	}
public static void testUpdateEmployee() {
	
	LOGGER.info("Start");
	Employee employee=employeeService.get(5);
	LOGGER.debug("Employee : {} ",employee);
	LOGGER.debug("Department : {} ",employee.getDepartment());
	Department department=departmentService.get(4);
	employee.setDepartment(department);
	employeeService.save(employee);
	LOGGER.debug("Employee : {} ",employee);
	LOGGER.debug("Department : {} ",employee.getDepartment());
	LOGGER.info("End");

}

	public static void testGetAllCountry() {
		LOGGER.info("start");
		List<Country> countriesList = service.getAllCountries();
		LOGGER.info("Countries : {}", countriesList);
		LOGGER.info("End");
	}

	public static void testGetCountry() {
		LOGGER.info("start");
		// List<Country> countriesList=service.getAllCountries();
		// LOGGER.info("Countries : {}",countriesList);

		List<Country> countrieslist=service.getCountryContain("ou");
		LOGGER.info("Countries : {}",countrieslist);
		
//		try {
//			Country country = service.findCountryByCode("IN");
//			LOGGER.info("Country :{}", country);
//		} catch (CountryNotFound e) {
//			// TODO Auto-generated catch block
//			LOGGER.error(e.getMessage());
//		}
		LOGGER.info("End");

	}

	public static void testAddCountry() {
		LOGGER.info("start");
		// List<Country> countriesList=service.getAllCountries();
		// LOGGER.info("Countries : {}",countriesList);

		Country country = new Country("YY", "New Country");
		service.addCountry(country);
		LOGGER.info("End");
	}

	public static void testUpdateCountry() {
		LOGGER.info("start");
		// List<Country> countriesList=service.getAllCountries();
		// LOGGER.info("Countries : {}",countriesList);
		try {
			service.updateCountry("YY", "New Country Modified");
		} catch (CountryNotFound e) {
			LOGGER.error(e.getMessage());

		}
		LOGGER.info("End");
	}

	public static void testDeleteCountry() {
		LOGGER.info("start");
		service.deleteCountry("YY");
		LOGGER.info("End");
	}
}
