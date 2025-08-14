package com.barclays.categories.model;


//for service layer CategoriesServiceImpl
public class CategoriesRequest {

	private String cardNum;
	private String clientId;
	private String ChannelId;
	private String reqId;
	private String msgTs;
	
	

	//create setters and getters or @setter and @getter/ @Data  using lambok
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getChannelId() {
		return ChannelId;
	}
	public void setChannelId(String channelId) {
		ChannelId = channelId;
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getMsgTs() {
		return msgTs;
	}
	public void setMsgTs(String msgTs) {
		this.msgTs = msgTs;
	}
	
	
	
}
