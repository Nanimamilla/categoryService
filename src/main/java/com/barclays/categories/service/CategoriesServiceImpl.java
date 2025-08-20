package com.barclays.categories.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barclays.categories.builder.CategoriesRequestBuilder;
import com.barclays.categories.builder.CategoriesResponseBuilder;
import com.barclays.categories.dao.ICategoriesDao;
import com.barclays.categories.exception.BusinessException;
import com.barclays.categories.exception.SystemException;
import com.barclays.categories.model.CardServiceClientReq;
import com.barclays.categories.model.CardServiceClientRes;
import com.barclays.categories.model.Categories;
import com.barclays.categories.model.CategoriesDao;
import com.barclays.categories.model.CategoriesDaoRequest;
import com.barclays.categories.model.CategoriesDaoResponse;
import com.barclays.categories.model.CategoriesRequest;
import com.barclays.categories.model.CategoriesResponse;
import com.barclays.categories.model.StatusBlock;
import com.barclays.categories.serviceClient.ICardVerifyServiceClient;

@Component
public class CategoriesServiceImpl implements ICategoriesService {
	
	
	// we use 2 integration layers
	// cardverify intergation layer1--Use only inetrfaces to call their
	// implementation DI @autowired
	@Autowired
	ICardVerifyServiceClient cardVerifySrvcClient;
	// dao Integration layer use only inetrfaces to call their implementation DI
	// @autowired
	@Autowired
	ICategoriesDao categoriesDao;
	
	
	//Use Builder class to create/build request and responses
	@Autowired
	CategoriesRequestBuilder requestBuilder;
	@Autowired
	CategoriesResponseBuilder  responseBuilder;

	
	
	@Override
	public CategoriesResponse getCategories(CategoriesRequest categoriesReq) throws BusinessException, SystemException {
		
		CategoriesDaoResponse categoriesDaoRes = new CategoriesDaoResponse();
		// 1.get the request from controller

		// 2.prepre the request for Intgration layer 1 cardverifyservice
		
		CardServiceClientReq cardServiceClientReq = requestBuilder.buildCardSvcClientRequest(categoriesReq);

		// 3. call cardVerifyService Intgration layer 1
		CardServiceClientRes cardVerifyResp = cardVerifySrvcClient.cardVerify(cardServiceClientReq);
		// 4.Apply the businness logic on CardVerifyResp
        
		if ("active".equals(cardVerifyResp.getStatus())) {
			
			// 5. Prepare the request for Intergration Layer2 CategoriesDao
			CategoriesDaoRequest categoriesDaoReq = requestBuilder.buildCategoriesDaoRequest(categoriesReq);
			// 6.Call CategoriesDao Intergration Layer2
            
			categoriesDaoRes = categoriesDao.getCategories(categoriesDaoReq);

		}

		// 7. prepare the Categories Response with the help of both integration layers
		// service client and dao.
		
		return responseBuilder.buildCategoriesResponse(cardVerifyResp,categoriesDaoRes);

		
		
	}

}
