package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Employee;
import com.cts.repository.EmployeeRespository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
@Autowired
public EmployeeRespository employeeRespository;

@Override
public List<Employee> getAllEmployees(){
	return employeeRespository.findAll();
}
@Override
public String addEmployee(Employee employee){
	employeeRespository.save(employee);
	return "Employee with Id "+employee.getId()+" added successully";
}
	

}
