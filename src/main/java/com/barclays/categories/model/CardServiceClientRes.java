package com.barclays.categories.model;


//for integration layer2 
public class CardServiceClientRes {
	//can use lambok and remove getters and setters using @Data etc.
	private String respCode;
	private String respMsg;
	private String status;
	
	
	
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
