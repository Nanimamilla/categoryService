package com.barclays.categories.service;

import com.barclays.categories.model.CategoriesRequest;
import com.barclays.categories.model.CategoriesResponse;

public interface ICategoriesService {

	public CategoriesResponse getCategories(CategoriesRequest categoresreq);
}
