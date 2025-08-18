package com.barclays.categories.exception;

import lombok.Getter;
import lombok.ToString;

@Getter // No need to use setter if you have constructor.
@ToString
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	private String respCode;
	private String respMsg;

	public BusinessException(String respCode, String respMsg) {
		this.respCode = respCode;
		this.respMsg = respMsg;
	}

}
