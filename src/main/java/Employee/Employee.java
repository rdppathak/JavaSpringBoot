package Employee;

import java.util.HashSet;
import java.util.Set;

import Department.Department;
import Role.Role;

public class Employee {
	
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private int age;
	private double salary;
	
	private Set<Role> role;
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

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	
}
