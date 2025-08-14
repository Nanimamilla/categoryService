package com.barclays.categories.validator;

import org.springframework.stereotype.Component;

import com.barclays.categories.model.CategoriesRequest;

@Component
public class CategoriesRequestValidator {

	//before sending request from control layer to service layer
	public void validateRequest(CategoriesRequest categoriesreq) {
		
		// TODO : validate the request, if the req is invalid,then send user defined exception.
	}
	

	
	

}
