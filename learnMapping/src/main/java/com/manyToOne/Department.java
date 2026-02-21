package com.manyToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="number_sequence")
	@SequenceGenerator(name="number",sequenceName="number_sequence",initialValue=100,allocationSize=1)
	private int id;
	private String name;
	private String managerName;
	private int no_Of_Emp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public int getNo_Of_Emp() {
		return no_Of_Emp;
	}
	public void setNo_Of_Emp(int no_Of_Emp) {
		this.no_Of_Emp = no_Of_Emp;
	}
	
	
	
	
	
}
