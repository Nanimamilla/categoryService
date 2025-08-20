package com.barclays.categories.builder;

import org.springframework.stereotype.Component;
//Building request object

import com.barclays.categories.model.CardServiceClientReq;
import com.barclays.categories.model.CategoriesDaoRequest;
import com.barclays.categories.model.CategoriesRequest;
@Component
public class CategoriesRequestBuilder {

	public CardServiceClientReq buildCardSvcClientRequest(CategoriesRequest categoriesReq)
	{
	//GENERTAE CardServiceClientReq (CardVerifyServiceclient) request
	CardServiceClientReq requesCardServiceClientReq = new CardServiceClientReq();
	requesCardServiceClientReq.setCardNum(categoriesReq.getCardNum());
	requesCardServiceClientReq.setClientId(categoriesReq.getClientId());
	requesCardServiceClientReq.setReqId(categoriesReq.getReqId());
	requesCardServiceClientReq.setMsgTs(categoriesReq.getMsgTs());
	return requesCardServiceClientReq;
	}
	
	
	//GENERTAE CategoriesDaoRequest
	public CategoriesDaoRequest buildCategoriesDaoRequest(CategoriesRequest categoriesReq)
	
	{
		CategoriesDaoRequest categoriesDaoReq =new CategoriesDaoRequest();
		categoriesDaoReq.setCardNum(categoriesReq.getCardNum());
		categoriesDaoReq.setChannelId(categoriesReq.getChannelId());
		categoriesDaoReq.setClientId(categoriesReq.getClientId());
		
		return categoriesDaoReq;
	}
	
}
