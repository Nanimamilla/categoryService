package com.barclays.categories.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barclays.categories.dao.ICategoriesDao;
import com.barclays.categories.model.CardServiceClientReq;
import com.barclays.categories.model.CardServiceClientRes;
import com.barclays.categories.model.CategoriesDaoRequest;
import com.barclays.categories.model.CategoriesDaoResponse;
import com.barclays.categories.model.CategoriesRequest;
import com.barclays.categories.model.CategoriesResponse;
import com.barclays.categories.serviceClient.ICardVerifyServiceClient;

@Component
public class CategoriesServiceImpl implements ICategoriesService {
	// we use 2 integration layers 
	//cardverify intergation layer1--Use only inetrfaces to call their implementation  DI @autowired
	@Autowired
	ICardVerifyServiceClient cardVerifySrvcClient;
	

	//dao Integration layer use only inetrfaces to call their implementation  DI  @autowired
	@Autowired
	ICategoriesDao categoriesDao; 

	@Override
	public CategoriesResponse getCategories(CategoriesRequest categoresreq) {
		//1.get the request from controller
		
		
		//2.prepre the request for Intgration layer 1 cardverifyservice
        CardServiceClientReq request =new CardServiceClientReq();
		//3. call cardVerifyService Intgration layer
        CardServiceClientRes CardServiceClientRes=cardVerifySrvcClient.cardVerify(request);
        //4.Apply the businness logic on CardVerifyResp
        
        //5. Prepare the request for Intergration Layer2 CategoriesDao
        CategoriesDaoRequest  CategoriesDaoReq= new CategoriesDaoRequest();
        //6.Call CategoriesDao  Intergration Layer2
        CategoriesDaoResponse CategoriesDaoRes=categoriesDao.getCategories(CategoriesDaoReq);
        //7. prepare the Categories Response with the help of both integration layers service client and dao.
        
        
        
		return null;
	}


}
