package com.product;
import javax.persistence.*;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();

		Product pro = new Product();

		 

		pro.setId(10); 
  
		pro.setName("Pennnn");

		pro.setPrice(1009);

		pro.setQuantity(5);
		
		dao.insertProduct(pro);
		

	}

}
