package com.example.demospringboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demospringboot.Entity.EmployeeModel;
@Repository
public interface EmployeeRepository  extends JpaRepository<EmployeeModel, Integer>
{

}
