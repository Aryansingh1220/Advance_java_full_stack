package com.securityPractice.securityPracticeDbConnection.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.securityPractice.securityPracticeDbConnection.entity.Account;
import com.securityPractice.securityPracticeDbConnection.repo.AccountJpaRepository;

public class DbDetailsUserService implements UserDetailsService{
	
	private AccountJpaRepository repository;
	public void DbDetailsService (AccountJpaRepository repository) {
		this.repository=repository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Account account=repository.findByUsername(username)
				.orElseThrow(()->new RuntimeException("Username notFound"));
		
		return null;
	}
	

}
