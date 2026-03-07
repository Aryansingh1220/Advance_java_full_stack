package com.securityPractice.securityPractice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping
public class PracticeController {
	
	@GetMapping("/practice")
	public String getDetails() {
		return "Details";
	}
	
	@GetMapping("admin")
	public String deleteUser() {
		return "Delete";
	}

}
