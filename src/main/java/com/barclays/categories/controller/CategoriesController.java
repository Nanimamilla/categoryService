package com.barclays.categories.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.categories.model.CategoriesResponse;

@RestController
public class CategoriesController {

	@GetMapping(("/categories/{cardnum}"))
	public CategoriesResponse getCategories(@PathVariable("cardnum") String cardnum,
			                                 @RequestHeader("clientId") String clientId,
			                                 @RequestHeader("channelId") String channelId,
			                                 @RequestHeader("requestId") String requestId,
			                                 @RequestHeader("message_ts") String message_ts)
	
	{
		CategoriesResponse categoriesResp= new CategoriesResponse();
		
		return null;
	
		
	}
}
