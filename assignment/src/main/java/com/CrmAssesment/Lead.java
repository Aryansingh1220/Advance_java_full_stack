package com.CrmAssesment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lead {
	
	@Id
	private int id;
	private String name;
	private String source;
	private long phone_num;
	

}
