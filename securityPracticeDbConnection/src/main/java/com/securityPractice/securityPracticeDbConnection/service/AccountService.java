package com.securityPractice.securityPracticeDbConnection.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.securityPractice.securityPracticeDbConnection.dto.AccountRequestDTO;
import com.securityPractice.securityPracticeDbConnection.entity.Account;
import com.securityPractice.securityPracticeDbConnection.repo.AccountJpaRepository;

@Service
public class AccountService {
	
	private AccountJpaRepository jpa;
	
	private PasswordEncoder encode;
	
	public AccountService(AccountJpaRepository jpa,PasswordEncoder encode) {
		this.jpa=jpa;
		this.encode=encode;
	}
	
	public void createAccount(AccountRequestDTO dto) {
		if(jpa.existsByUsername(dto.getUsername())){
			throw new RuntimeException("User Name Exists");
		}
		if(jpa.existsByEmail(dto.getEmail())) {
			throw new RuntimeException("User Email Exists");
		}
		
		Account account=new Account();
		account.setUsername(dto.getUsername());
		account.setFullname(dto.getFullname());
		account.setPassword(dto.getPassword());
		account.setPhone(dto.getPhone());
		account.setCreatedAt(dto.getCreatedAt());
		account.setEmail(dto.getEmail());
		account.setRole(dto.getRole());
	}
	
	public String normalizeAndValidateRole(String role) {
		if(role==null || role.trim().isEmpty()) {
			return "ROLE_USER";
		}
		String r=role.trim().toUpperCase();
		if(!r.startsWith("ROLE_")) {
			r="ROLE_"+r;
		}
		
		if(role.equalsIgnoreCase("ROLE_USER") || role.equalsIgnoreCase("ROLE_ADMIN")) {
			throw new RuntimeException("Invalid User");
		}
		
		return r;
	}
	
	public AccountResponseDTO toResponse(Account a) {
		
	}

}
