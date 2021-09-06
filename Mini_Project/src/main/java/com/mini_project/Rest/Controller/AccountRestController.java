package com.mini_project.Rest.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mini_project.Entity.Account;
import com.mini_project.Service.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
	@Autowired
	AccountService accountService;
	
	@GetMapping
	public List<Account> getAccounts(@RequestParam("admin") Optional<Boolean> admin){
		if(admin.orElse(false)) {
			return accountService.getAdministrators();
		}
		return accountService.findAll();
	}
	
	@GetMapping("/all_user")
	public List<Account> getAll(){
		return accountService.findAll();
	}
	
	@PostMapping
	public Account create(@RequestBody Account account) {
		return accountService.create(account);
	}
	
	@PutMapping("{id}")
	public Account update(@PathVariable("id") String username, @RequestBody Account account) {
		return accountService.update(account);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String username) {
		accountService.delete(username);
	}
	
	@GetMapping("{username}")
	public Account getOne(@PathVariable("username") String username) {
		return accountService.findById(username);
	}
	
	@GetMapping("/timkiemUsername/{username}")
	public List<Account> getUsername(@PathVariable("username")String username) {
		return accountService.findByUsername("%"+ username + "%");
	}
}
