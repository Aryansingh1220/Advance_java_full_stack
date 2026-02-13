package com.basics;


//Bussiness logic -- calculation part kind of dsa logic


public class UserService {
	
	private UserDao dao;//null value
	 
	
	public UserService(UserDao dao) {
		this.dao=dao;
	}
	
	public String  typeOfUser(int id) {
		User user=dao.findByID(id);
		if(user.getBalance()>0 && user.getBalance()<=1000) {
			return "new user";
			
		}
		else if(user.getBalance()>1000 && user.getBalance()<=2000) {
			return "regular user";
		}
		else {
			return "premium user";
		}
	}
	
}
