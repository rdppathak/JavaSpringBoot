package com.Company.Role;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.Company.Role.Role;

@Transactional
public interface RoleRepository extends CrudRepository<Role, Long>{
	Role findByTitle(String title);
}
