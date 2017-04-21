package com.Company.Employee;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.Company.Department.Department;
import com.Company.MindEntity.MindEntity;
import com.Company.Role.Role;

@Entity
@Table(name="Employees", uniqueConstraints={@UniqueConstraint(columnNames = {"firstName", "lastName"})})
@AttributeOverride(name = "id", column =@Column(name = "EMPLOYEE_ID"))
public class Employee extends MindEntity{
	
//	@Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//	private long id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;
	@Column
	private int age;
	@Column
	private double salary;
	
	@ManyToMany(targetEntity=Role.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "EMP_ROLE", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<Role> role;
	
	@ManyToMany(targetEntity=Department.class, cascade = CascadeType.ALL)
	@JoinTable(name = "EMP_DEPARTMENT", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"), inverseJoinColumns = @JoinColumn(name="DEPARTMENT_ID"))
	private Set<Department> department;

	public Employee(){
		
	}
	
	public Employee(String firstName, String lastName, String email, int age, double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.salary = salary;
		this.role = new HashSet<Role>();
		this.department = new HashSet<Department>();
	}

//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public Role getRole(String title) {
		for(Role r: role){
			if(r.getTitle()==title)
				return r;
		}
		return null;
	}

	public void setRole(Role role) {
		this.role.add(role);
	}

	public void removeRole(String title){
		for(Role r: role){
			if (r.getTitle() == title){
				role.remove(r);
				return;
			}
		}
	}
	
	public Department getDepartment(String departmentName) {
		for(Department d: department){
			if (d.getName() == departmentName){
				return d;
			}
		}
		return null;
	}

	public void setDepartment(Department department) {
		this.department.add(department);
	}
	
	public void removeDepartment(String departmentName){
		for(Department d: department){
			if(d.getName() == departmentName){
				department.remove(d);
				return;
			}
		}
	}
	
}
