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

//.
/*
 @PatchMapping============
 1) @RestController=>   (@controller + @rest(json reply)+@ResponseBody)
 2) @RequestMapping=> old code ,modern using
    @GetMapping
    @PutMapping
    @PostMapping
    @DeleteMapping
  3) @pathVariable => get a variable from the url 
  4) @RequestParam => get a Request param data from url (after ?)(likeQueryparam )
  5) @RequestHeader=> headers added in api request
  6)@RequestBody   => request body that is added in a api request 
  7) @ResponseBody => returning the response data in api
  8) @crossOrigin, @ExceptionHandler, @ResponseStatus => allow multiple origin of request,
                                            exceptions, send response status
 
 
 
 
 */

@RequestMapping("/v1")
@RestController
public class CategoriesController {
	
	@Autowired
	CategoriesRequestValidator requestValidator;
	@Autowired
	 ICategoriesService categoriesSrvc;
	
	
    /* to test:
     http://localhost:2025/v1/categories/7687
     Headers:
     
     [{"key":"clientId","value":"online",},
     {"key":"requestId","value":"abc123xyz"},
     {"key":"channelId","value":"web"},
     {"key":"message_ts","value":"08-14-2025"}
     ]
     */
	
	@GetMapping(("/categories/{cardnum}"))
	public CategoriesResponse getCategories(@PathVariable("cardnum") String cardnum,
			                                 @RequestHeader("clientId") String clientId,
			                                 @RequestHeader("channelId") String channelId,
			                                 @RequestHeader("requestId") String requestId,
			                                 @RequestHeader("message_ts") String message_ts)
	
	{
		// get the requests from consumer or client
		CategoriesRequest categoriesReq= new CategoriesRequest();
		categoriesReq.setCardNum(cardnum);
		categoriesReq.setClientId(clientId);
		categoriesReq.setChannelId(channelId);
		categoriesReq.setReqId(requestId);
		categoriesReq.setMsgTs(message_ts);
		
		
		//validate the  request
		requestValidator.validateRequest(categoriesReq);
		
		//connecting to service layer using Categoriesreq
		CategoriesResponse categoriesres=categoriesSrvc.getCategories(categoriesReq);
		
		return categoriesres;
	
		
	}
}
