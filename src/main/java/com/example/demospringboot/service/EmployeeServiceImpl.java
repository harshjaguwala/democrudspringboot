package com.example.demospringboot.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demospringboot.Entity.EmployeeModel;
import com.example.demospringboot.repository.EmployeeRepository;

import lombok.AllArgsConstructor;


@Component
//@ComponentScan("com.example.demospringboot.repository")
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeRepository emprepo;

	@Override
	public EmployeeModel createEmployee(EmployeeModel e) 
	{
		return emprepo.save(e);
	}

	@Override
	public EmployeeModel getEmployeeById(Integer empid) 
	{
		Optional<EmployeeModel> optionalUser = null;
		try {
			 optionalUser = emprepo.findById(empid);
		}
		catch (NoSuchElementException  e) {
			e.printStackTrace(); 
		}
		return optionalUser.get();
	}

	@Override
	public List<EmployeeModel> getAllEmployee() {
		return emprepo.findAll();
	}

	@Override
	public EmployeeModel updateEmployee(EmployeeModel e) 
	{
		EmployeeModel existingEmployee = emprepo.findById(e.getId()).get();
		existingEmployee.setName(e.getName());
		existingEmployee.setAge(e.getAge());
		EmployeeModel updatedEmployee = emprepo.save(existingEmployee);
		return updatedEmployee;
	}

	@Override
	public void deleteEmployee(Integer id)
	{
		emprepo.deleteById(id);
	}
	
	
}
