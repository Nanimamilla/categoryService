package com.barclays.categories.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	@Override
	public CategoriesResponse getCategories(CategoriesRequest categoriesReq) throws BusinessException, SystemException {
		CategoriesDaoResponse categoriesDaoRes = new CategoriesDaoResponse();
		// 1.get the request from controller

		// 2.prepre the request for Intgration layer 1 cardverifyservice

		CardServiceClientReq request = new CardServiceClientReq();
		request.setCardNum(categoriesReq.getCardNum());
		request.setClientId(categoriesReq.getClientId());
		request.setReqId(categoriesReq.getReqId());
		request.setMsgTs(categoriesReq.getMsgTs());

		// 3. call cardVerifyService Intgration layer
		CardServiceClientRes cardVerifyResp = cardVerifySrvcClient.cardVerify(request);
		// 4.Apply the businness logic on CardVerifyResp

		if ("active".equals(cardVerifyResp.getStatus())) {

			// 5. Prepare the request for Intergration Layer2 CategoriesDao
			CategoriesDaoRequest categoriesDaoReq = new CategoriesDaoRequest();

			/*
			 * 
			 * //start check later CategoriesDaoReq.setCardNum(categoriesReq.getCardNum());
			 * CategoriesDaoReq.setChannelId(categoriesReq.getChannelId());
			 * CategoriesDaoReq.setClientId(categoriesReq.getClientId());
			 * 
			 * //end
			 */

			// 6.Call CategoriesDao Intergration Layer2

			categoriesDaoRes = categoriesDao.getCategories(categoriesDaoReq);

		}

		// 7. prepare the Categories Response with the help of both integration layers
		// service client and dao.

		CategoriesResponse categoriesResp = new CategoriesResponse();

		// private StatusBlock status; remove
		// private List<Categories> categories;remove

		StatusBlock statusBlock = new StatusBlock();
		statusBlock.setRespMsg(categoriesDaoRes.getDbRespMsg());
		statusBlock.setRespCode(categoriesDaoRes.getDbRespCode());
		categoriesResp.setStatus(statusBlock);

		List<Categories> categoriesList = new ArrayList<Categories>();
		for (CategoriesDao catDao : categoriesDaoRes.getCategoriesDao()) {
			// or use java Stream api
			Categories categories = new Categories();
			categories.setId(catDao.getId());
			categories.setName(catDao.getName());
			categories.setDesc(catDao.getDesc());
			categories.setStatus(catDao.getStatus());
			categories.setType(catDao.getType());
			categories.setExpDate(catDao.getExpDate());

			categoriesList.add(categories);

		}
		categoriesResp.setStatus(statusBlock);
		categoriesResp.setCategories(categoriesList);

		return categoriesResp;
	}

}
