package com.mini_project.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini_project.DAO.AccountDAO;
import com.mini_project.Entity.Account;
import com.mini_project.Service.AccountService;

@Service
public class AccountServiceimpl implements AccountService{
	@Autowired
	AccountDAO adao;

	@Override
	public Account findById(String username) {
		return adao.findById(username).get();
	}

	@Override
	public List<Account> getAdministrators() {
		return adao.getAdministrators();
	}

	@Override
	public List<Account> findAll() {
		return adao.findAll();
	}

	@Override
	public Account create(Account account) {
		return adao.save(account);
	}

	@Override
	public Account update(Account account) {
		return adao.save(account);
	}

	@Override
	public void delete(String username) {
		adao.deleteById(username);
		
	}

	@Override
	public List<Account> findByUsername(String username) {
		return adao.findByUsername(username);
	}

}
