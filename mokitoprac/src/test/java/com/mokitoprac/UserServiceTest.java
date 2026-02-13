package com.mokitoprac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.basics.Calculator;
import com.basics.MathService;
import com.basics.UserDao;
import com.basics.UserService;

public class UserServiceTest {
	
	@Test 
	public void testGetTypeOfUser() {
		UserDao dao=new UserDao();
		UserService service=new UserService(dao);
		
		String actualRes=service.typeOfUser(1);
		
		assertEquals("Premium user",actualRes);
	}
	
	@Test
	public void testDoubleAddition() {
		
		//step 1 : create fake or moke object
		Calculator calmock=mock(Calculator.class);
		
		//step 2 : what mock object should return
		when(calmock.add(10, 20)).thenReturn(33);
		
		// step 3 : give the fake object reference -inject the mock reference
		
		MathService service=new MathService(calmock);
		
		int res=service.doubleAddition(10, 20);
		
		assertEquals(20,res);
	}
} 
