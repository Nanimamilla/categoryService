package com.barclays.categories.model;

import lombok.Data;

//for integration layer2 
@Data
public class CardServiceClientRes {
	// can use lambok and remove getters and setters using @Data etc.
	private String respCode;
	private String respMsg;
	private String status;

}
