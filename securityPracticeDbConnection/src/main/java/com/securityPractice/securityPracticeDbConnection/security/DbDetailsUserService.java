package com.securityPractice.securityPracticeDbConnection.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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
		
		List<SimpleGrantedAuthority> authorities=new ArrayList();
		
		authorities.add(new SimpleGrantedAuthority(account.getRole()));
		
		
		return new User(account.getUsername(),account.getPassword(),null);
	}
	

}
