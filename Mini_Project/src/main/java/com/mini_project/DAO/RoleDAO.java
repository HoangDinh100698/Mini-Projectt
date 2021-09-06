package com.mini_project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini_project.Entity.Role;

public interface RoleDAO extends JpaRepository<Role, String> {

}
