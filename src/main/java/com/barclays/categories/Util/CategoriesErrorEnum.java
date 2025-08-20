package com.barclays.categories.Util;

import lombok.Getter;

@Getter
public enum CategoriesErrorEnum {

	//Declaring enum as instances and called with constructor of tis calss.
	clientIdInvalid("100","Invalid Client id","data error"),
	cardNumberInvalid("101","Invalid Client id","data error"),
	CardNumberNotMappedCVV("102","Invalid Client Id","data error"),
	DatabaseTimeout("333","database time out","system Error"),
	dataBaseDown("444","database down","system error");
	
	
	private String errorCode;
	private String errorMsg;
	private String typeOfError;
	
	CategoriesErrorEnum(String respCode, String respMsg, String typeOfError) {
		this.errorCode=respCode;
		this.errorMsg=respMsg;
		this.typeOfError=typeOfError;
		// TODO Auto-generated constructor stub
	}
	
	public static boolean checkErrorCodeFromEnum(String errorCode,String errorType)
	{
		boolean found=false;
		for(CategoriesErrorEnum catEnum:CategoriesErrorEnum.values())
		{
			if(errorCode.equals(catEnum.getErrorCode()) && errorType.equals(catEnum.getTypeOfError())) {
				found=true;
				
			}
			
		}
		return found;
	}
	
	
}
