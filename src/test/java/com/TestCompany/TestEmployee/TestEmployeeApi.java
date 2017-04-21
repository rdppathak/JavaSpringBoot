package com.TestCompany.TestEmployee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;

import com.Company.Department.Department;
import com.Company.Employee.Employee;
import com.Company.Role.Role;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DataJpaTest
public class TestEmployeeApi{
	
	@Autowired
    private MockMvc mockMvc;
	
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
