package com.Company.Department;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.Company.Department.Department;

@Transactional
public interface DepartmentRepository extends CrudRepository<Department, Long>{
	Department findByName(String name);
}
