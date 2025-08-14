package com.barclays.categories.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.categories.model.CategoriesRequest;
import com.barclays.categories.model.CategoriesResponse;
import com.barclays.categories.service.ICategoriesService;
import com.barclays.categories.validator.CategoriesRequestValidator;




@RequestMapping("/v1")
@RestController
public class CategoriesController {
	
	@Autowired
	CategoriesRequestValidator requestValidator;
	 ICategoriesService categoriesSrvc;
	
	
	
	
	
	

	@GetMapping(("/categories/{cardnum}"))
	public CategoriesResponse getCategories(@PathVariable("cardnum") String cardnum,
			                                 @RequestHeader("clientId") String clientId,
			                                 @RequestHeader("channelId") String channelId,
			                                 @RequestHeader("requestId") String requestId,
			                                 @RequestHeader("message_ts") String message_ts)
	
	{
		// get the requets from consumer or client
		CategoriesRequest categoriesreq= new CategoriesRequest();
		
		
		//validate the  request
		requestValidator.validateRequest(categoriesreq);
		
		//connecting to service layer using Categoriesreq
		CategoriesResponse categoriesres=categoriesSrvc.getCategories(categoriesreq);
		
		return categoriesres;
	
		
	}
}
