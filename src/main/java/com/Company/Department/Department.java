package com.Company.Department;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.Company.MindEntity.MindEntity;

@Entity
@Table(name="departments")
@AttributeOverride(name = "id", column =@Column(name = "DEPARTMENT_ID"))
public class Department extends MindEntity{

	@Column(unique=true)
	private String name;
	@Column
	private String description;
	
	public Department(){
		
	}
	
	public Department(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
