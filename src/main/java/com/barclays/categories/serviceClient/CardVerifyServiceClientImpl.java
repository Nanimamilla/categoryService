package com.barclays.categories.serviceClient;

import org.springframework.stereotype.Component;

import com.barclays.categories.model.CardServiceClientReq;
import com.barclays.categories.model.CardServiceClientRes;

@Component
public class CardVerifyServiceClientImpl implements ICardVerifyServiceClient {
	@Override
	public CardServiceClientRes cardVerify(CardServiceClientReq request) {
		
		CardServiceClientRes cardServClientResp = new CardServiceClientRes();
		//TODO hardcode respcode,respmsg,status for now, later remove it from db data
		
		
		
		cardServClientResp.setRespCode("0");
		cardServClientResp.setRespMsg("success");
		cardServClientResp.setStatus("active");
		return cardServClientResp;
	}

}
