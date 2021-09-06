package com.mini_project.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mini_project.Entity.Account;
import com.mini_project.Entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer> {
	
	@Query("SELECT DISTINCT a FROM Authority a WHERE a.account IN ?1")
	List<Authority> authoritiesOf(List<Account> accounts);

}