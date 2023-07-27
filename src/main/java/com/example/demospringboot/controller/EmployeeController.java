package com.example.demospringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demospringboot.Entity.EmployeeModel;
import com.example.demospringboot.service.EmployeeService;


@RestController
@ComponentScan("com.example.demospringboot.service")
@RequestMapping("api/Employee")
public class EmployeeController {
	@Autowired(required = true)
	private EmployeeService empservice;

	@GetMapping("getAllEmployee")
	public ResponseEntity<List<EmployeeModel>> getAllEmployee() {
		System.out.println("calling");
		List<EmployeeModel> emp = empservice.getAllEmployee();
		if(emp.size() <= 0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		//return new ResponseEntity<>(emp, HttpStatus.OK);
		return ResponseEntity.of(Optional.of(emp));
	}

	@PostMapping
	public ResponseEntity<EmployeeModel> createEmployee(@RequestBody EmployeeModel emp) {
		EmployeeModel savedEmp = null;
		try {
			savedEmp = empservice.createEmployee(emp);
			return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable("id") Integer empid) {
		EmployeeModel empbyid = empservice.getEmployeeById(empid);
		if(empbyid == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
//		return new ResponseEntity<>(empbyid, HttpStatus.OK);
		return ResponseEntity.of(Optional.of(empbyid));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable("id") Integer empid,@RequestBody EmployeeModel emp){
        emp.setId(empid);
        EmployeeModel updatedEmp = empservice.updateEmployee(emp);
        return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
    }

    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer empid){
    	empservice.deleteEmployee(empid);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
