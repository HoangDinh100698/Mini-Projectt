package com.mini_project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini_project.Entity.Category;

public interface CaterorityDAO extends JpaRepository<Category, String> {

}