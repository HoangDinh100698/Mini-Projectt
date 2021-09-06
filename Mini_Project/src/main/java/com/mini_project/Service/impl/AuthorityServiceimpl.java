package com.mini_project.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini_project.DAO.AccountDAO;
import com.mini_project.DAO.AuthorityDAO;
import com.mini_project.Entity.Account;
import com.mini_project.Entity.Authority;
import com.mini_project.Service.AuthorityService;

@Service
public class AuthorityServiceimpl implements AuthorityService{
	@Autowired
	AuthorityDAO audao;
	
	@Autowired
	AccountDAO acdao;

	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = acdao.getAdministrators();
		return audao.authoritiesOf(accounts);
	}

	@Override
	public List<Authority> findAll() {
		return audao.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		return audao.save(auth);
	}

	@Override
	public void delete(Integer id) {
		audao.deleteById(id);
		
	}
}
