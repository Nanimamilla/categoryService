package com.barclays.categories.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.barclays.categories.Util.CategoriesConstant;
import com.barclays.categories.builder.CategoriesResponseBuilder;
import com.barclays.categories.exception.BusinessException;
import com.barclays.categories.exception.CategoriesRequestInvalidException;
import com.barclays.categories.exception.SystemException;
import com.barclays.categories.model.CategoriesResponse;
import com.barclays.categories.model.StatusBlock;

// write any exceptions in controller in this 
@ControllerAdvice
@ResponseBody
public class CategoriesControllerAdvice {
	
	@Autowired
	CategoriesResponseBuilder categoriesResponseBuilder;

	@ExceptionHandler(value = CategoriesRequestInvalidException.class) // So in your layered arch, exceptions bubble up
																		// from
	// CategoriesController ->CategoriesRTequestValidator-> DispatcherServlet →
	// ControllerAdvice automatically.
	public CategoriesResponse handleException(CategoriesRequestInvalidException crie)

	{
		System.out.println("entered CategoriesControllerAdvice ");

		System.out.println("exit CategoriesControllerAdvice CategoriesRequestInvalidException");
		return categoriesResponseBuilder.buildCategoriesResponse(crie.getRespCode(), crie.getRespMsg());

	}

	@ExceptionHandler(value = BusinessException.class)
	// CheckedException path
	// CategoriesDaoImpl ->CategoriesServiceImpl->CategoriesController ->
	// CategoriesControllerAdvice
	public CategoriesResponse handleDataError(BusinessException be) {

		System.out.println("exit CategoriesControllerAdvice BusinessException");
		return categoriesResponseBuilder.buildCategoriesResponse(be.getRespCode(), be.getRespMsg());

	}

	@ExceptionHandler(value = SystemException.class)
	// CheckedException path
	// CategoriesDaoImpl ->CategoriesServiceImpl->CategoriesController ->
	// CategoriesControllerAdvice
	public CategoriesResponse handleException(SystemException se) {
		System.out.println("exit CategoriesControllerAdvice SystemException");
		return categoriesResponseBuilder.buildCategoriesResponse(se.getRespCode(), se.getRespMsg());

	}

	@ExceptionHandler(value = Exception.class)

	public CategoriesResponse handleGenericException(Exception e) {

		System.out.println("exit CategoriesControllerAdvice SystemException");
		return categoriesResponseBuilder.buildCategoriesResponse(CategoriesConstant.GEN_ERROR_CODE, CategoriesConstant.GEN_ERROR_MSG);

	}

}
