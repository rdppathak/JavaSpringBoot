package com.Company.Role;

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
@Table(name="roles")
@AttributeOverride(name = "id", column =@Column(name = "ROLE_ID"))
public class Role extends MindEntity{

	@Column(unique=true)
	private String title;
	@Column
	private String description;
	
	public Role(){
		
	}
	public Role(String title, String description) {
		this.title = title;
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
