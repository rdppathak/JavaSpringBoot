package com.Company.Employee;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Company.Employee.*;

import com.Company.Department.Department;
import com.Company.Department.DepartmentRepository;
import com.Company.Role.Role;
import com.Company.Role.RoleRepository;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@RequestMapping("/createEmployee")
	public Employee create(@RequestParam(value = "firstName", defaultValue = "User") String firstName,
			@RequestParam(value = "lastName", defaultValue = "lastName") String lastName,
			@RequestParam(value = "emailid") String emailid,
			@RequestParam(value = "age", defaultValue = "25") int age,
			@RequestParam(value = "salary", defaultValue = "10000") float salary) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setAge(age);
		employee.setSalary(salary);
		employee.setEmail(emailid);
		employee = employeeRepository.save(employee);
		return employee;
	}

	@RequestMapping("/addEmployeeRole")
	public Employee setEmployeeRole(@RequestParam(value="firstName") String firstName,
						@RequestParam(value="lastName") String lastName,
						@RequestParam(value="title") String title,
						@RequestParam(value="description") String description){
		Employee e;
		e = employeeRepository.findByFirstNameAndLastName(firstName, lastName);
		if (e == null){
			return e;
		}else{
			
			Role r =null;
			r = roleRepository.findByTitle(title);
			if (r==null){
				r = new Role(title, description);
			}
			roleRepository.save(r);
			e.setRole(r);
			employeeRepository.save(e);			
		}
		return e;
	}
	
	@RequestMapping("/addEmployeeProject")
	public Employee setEmployeeProject(@RequestParam(value="firstName") String firstName,
			@RequestParam(value="lastName") String lastName,
			@RequestParam(value="name") String projName,
			@RequestParam(value="description") String description){
		Employee e;
		e = employeeRepository.findByFirstNameAndLastName(firstName, lastName);
		if (e == null){
			return e;
		}else{
			Department p = null;
			p = departmentRepository.findByName(projName);
			if (p==null){
				p = new Department(projName, description);
			}
			departmentRepository.save(p);
			e.setDepartment(p);
			employeeRepository.save(e);			
		}
		return e;
	}
	
	@RequestMapping("/removeEmployeeRole")
	public Employee removeEmployeeRole(@RequestParam(value="firstName") String firstName,
					@RequestParam(value="lastName") String lastName,
					@RequestParam(value="title") String title){
		Employee e;
		e = employeeRepository.findByFirstNameAndLastName(firstName, lastName);
		if (e == null){
			return e;
		}else{
			e.removeRole(title);
		}
		employeeRepository.save(e);
		return e;
	}
	
	@RequestMapping("/deleteEmployee")
	public Employee deleteEmployeeDetails(@RequestParam(value="firstName") String firstName,
						@RequestParam(value="lastName") String lastName){
		Employee e;
		e = employeeRepository.findByFirstNameAndLastName(firstName, lastName);
		employeeRepository.delete(e);
		return null;
	}
	
	
}
