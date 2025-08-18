package com.barclays.categories.validator;

import org.springframework.stereotype.Component;

import com.barclays.categories.model.CategoriesRequest;
import com.barclays.categories.exception.CategoriesRequestInvalidException;

@Component
public class CategoriesRequestValidator {

	// before sending request from control layer to service layer
	public void validateRequest(CategoriesRequest categoriesReq) throws CategoriesRequestInvalidException {
		if (categoriesReq == null) {
			throw new CategoriesRequestInvalidException("cat001", "Invalid Request object");
		}

		if (categoriesReq.getCardNum() == null || categoriesReq.getCardNum().equals(" ")) {
			throw new CategoriesRequestInvalidException("cat002", "Invalid card  Number");
		}

		if (categoriesReq.getClientId() == null || categoriesReq.getClientId().equals(" ")) {
			throw new CategoriesRequestInvalidException("cat003", "Invalid ClientId ");
		}

		if (categoriesReq.getChannelId() == null || categoriesReq.getChannelId().equals(" ")) {
			throw new CategoriesRequestInvalidException("cat004", "Invalid Channel id");
		}

		if (categoriesReq.getReqId() == null || categoriesReq.getReqId().equals(" ")) {
			throw new CategoriesRequestInvalidException("cat006", "Invalid ReqId  ");
		}

	}

}
