package com.mini_project.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini_project.DAO.CaterorityDAO;
import com.mini_project.Entity.Category;
import com.mini_project.Service.CategoryService;



@Service
public class CategoryServiceimpl implements CategoryService {
	@Autowired
	CaterorityDAO cdao;
	@Override
	public List<Category> findAll() {
		return cdao.findAll();
	}

}
