package com.barclays.categories.model;

import java.util.List;

//for  integration layer1 dao CategoriesDaoImpl
public class CategoriesDaoResponse {

	private String dbRespCode;
	private String dbRespMsg;
	private List<CategoriesDao> categoriesDao;
	
	//TODO remove getters and setters and add @Data
	public String getDbRespCode() {
		return dbRespCode;
	}
	public void setDbRespCode(String dbRespCode) {
		this.dbRespCode = dbRespCode;
	}
	public String getDbRespMsg() {
		return dbRespMsg;
	}
	public void setDbRespMsg(String dbRespMsg) {
		this.dbRespMsg = dbRespMsg;
	}
	public List<CategoriesDao> getCategoriesDao() {
		return categoriesDao;
	}
	public void setCategoriesDao(List<CategoriesDao> categoriesDao) {
		this.categoriesDao = categoriesDao;
	}
}
