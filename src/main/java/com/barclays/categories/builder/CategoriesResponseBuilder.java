package com.barclays.categories.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.barclays.categories.model.CardServiceClientRes;
import com.barclays.categories.model.Categories;
import com.barclays.categories.model.CategoriesDao;
import com.barclays.categories.model.CategoriesDaoResponse;
import com.barclays.categories.model.CategoriesResponse;
import com.barclays.categories.model.StatusBlock;

//Building Response Object
@Component
public class CategoriesResponseBuilder {

	
	//category response success case called in service layer
	public CategoriesResponse buildCategoriesResponse(CardServiceClientRes cardVerifyResp, CategoriesDaoResponse categoriesDaoRes) {

		CategoriesResponse categoriesResp = new CategoriesResponse();

		// private StatusBlock status; remove
		// private List<Categories> categories;remove

		StatusBlock statusBlock = new StatusBlock();
		statusBlock.setRespMsg(categoriesDaoRes.getDbRespMsg());
		statusBlock.setRespCode(categoriesDaoRes.getDbRespCode());
		categoriesResp.setStatus(statusBlock);

		List<Categories> categoriesList = new ArrayList<Categories>();
		for (CategoriesDao catDao : categoriesDaoRes.getCategoriesDao()) {
			// or use java Stream api
			Categories categories = new Categories();
			categories.setId(catDao.getId());
			categories.setName(catDao.getName());
			categories.setDesc(catDao.getDesc());
			categories.setStatus(catDao.getStatus());
			categories.setType(catDao.getType());
			categories.setExpDate(catDao.getExpDate());

			categoriesList.add(categories);

		}
		categoriesResp.setStatus(statusBlock);
		categoriesResp.setCategories(categoriesList);
		
		return categoriesResp;

	}
	//CategoryResponse failure case called in CategoriesControllerAdvice
	
	public CategoriesResponse buildCategoriesResponse(String respCode, String respMsg) {
		CategoriesResponse categoriesResp = new CategoriesResponse();

		StatusBlock statusBlk = new StatusBlock();
		statusBlk.setRespCode(respCode);
		statusBlk.setRespMsg(respMsg);

		categoriesResp.setStatus(statusBlk);
		return categoriesResp;
	}

}
