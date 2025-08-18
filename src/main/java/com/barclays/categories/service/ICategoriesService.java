package com.barclays.categories.service;

import com.barclays.categories.exception.BusinessException;
import com.barclays.categories.exception.SystemException;
import com.barclays.categories.model.CategoriesRequest;
import com.barclays.categories.model.CategoriesResponse;

public interface ICategoriesService {

	public CategoriesResponse getCategories(CategoriesRequest categoresreq) throws BusinessException, SystemException;
}
