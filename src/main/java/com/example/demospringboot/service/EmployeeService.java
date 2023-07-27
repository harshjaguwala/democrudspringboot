package com.example.demospringboot.service;

import java.util.List;

import com.example.demospringboot.Entity.EmployeeModel;


public interface EmployeeService 
{
	public EmployeeModel createEmployee(EmployeeModel e);
	
	public EmployeeModel getEmployeeById(Integer empid);
	
	public List<EmployeeModel> getAllEmployee();
	
	public EmployeeModel updateEmployee(EmployeeModel e);
	
	public void deleteEmployee(Integer id);
	
}
