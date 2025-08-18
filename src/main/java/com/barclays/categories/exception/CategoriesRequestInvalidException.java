package com.barclays.categories.exception;

import lombok.Getter;
import lombok.ToString;

//If control layer error
@Getter // No need to use setter if you have constructor.
@ToString
public class CategoriesRequestInvalidException extends NullPointerException {

	private static final long serialVersionUID = 1L;
	private String respCode;
	private String respMsg;

	// using lombok

//	public String getRespCode() {
//		return respCode;
//	}
//	public void setRespCode(String respCode) {
//		this.respCode = respCode;
//	}
//	public String getRespMsg() {
//		return respMsg;
//	}
//	public void setRespMsg(String respMsg) {
//		this.respMsg = respMsg;
	// }
	public CategoriesRequestInvalidException(String respCode, String respMsg) {
		this.respCode = respCode;
		this.respMsg = respMsg;
	}

}
