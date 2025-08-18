package com.barclays.categories.dao;

import com.barclays.categories.exception.BusinessException;
import com.barclays.categories.exception.SystemException;
import com.barclays.categories.model.CategoriesDaoRequest;
import com.barclays.categories.model.CategoriesDaoResponse;

public interface ICategoriesDao {

	public CategoriesDaoResponse getCategories(CategoriesDaoRequest categoriesReq)
			throws BusinessException, SystemException;
}
