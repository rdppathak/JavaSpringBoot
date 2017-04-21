package com.Company.Employee;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.Company.Employee.Employee;

@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	Employee findByFirstNameAndLastName(String firstName, String lastName);
}