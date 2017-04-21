package com.TestCompany.TestEmployee;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import Department.Department;
import Employee.Employee;
import Role.Role;

public class TestEmployeeApi extends AbstractTestNGSpringContextTests{
	
	@Test
	public Employee createEmployee() {
		Employee employee = new Employee("John", "Quest", "john.quest@abcmail.com", 29, 1000.0);
		return employee;
	}

	@Test
	public void addEmployeeRole() {
		Employee employee = createEmployee();
		Role role = new Role("Software Engineer-1", "Prgramming");
		employee.setRole(role);
	}

	@Test
	public void addEmployeeDepartment() {
		Employee employee = createEmployee();
		Department department  = new Department("Mindsphere", "IOT Platform");
		employee.setDepartment(department);
	}

	@Test
	public void updateEmployeeRole() {

	}

	@Test
	public void updateEmployeeDepartment() {

	}

	@Test
	public void removeEmployeeRole() {

	}

	@Test
	public void removeEmployeeDepartment() {

	}
	
	@Test
	public void deleteEmployee(){
		
	}
}
