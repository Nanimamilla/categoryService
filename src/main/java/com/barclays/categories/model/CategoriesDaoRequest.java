package com.barclays.categories.model;


//for integration layer1 dao CategoriesDaoImpl
//@Data
public class CategoriesDaoRequest {

	private String cardNum;
	private String clientId;
	private String ChannelId;
	
	
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
	

}
