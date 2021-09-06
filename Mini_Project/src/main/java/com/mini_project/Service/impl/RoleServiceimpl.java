package com.mini_project.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini_project.DAO.RoleDAO;
import com.mini_project.Entity.Role;
import com.mini_project.Service.RoleService;

@Service
public class RoleServiceimpl implements RoleService{
	@Autowired
	RoleDAO dao;

	@Override
	public List<Role> findAll() {
		return dao.findAll();
	}
	
}
