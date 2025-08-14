package com.barclays.categories.serviceClient;

import com.barclays.categories.model.CardServiceClientReq;
import com.barclays.categories.model.CardServiceClientRes;

public interface ICardVerifyServiceClient {

	public CardServiceClientRes cardVerify(CardServiceClientReq request);
}
