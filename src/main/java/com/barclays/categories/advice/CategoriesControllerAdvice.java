package com.barclays.categories.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.barclays.categories.exception.BusinessException;
import com.barclays.categories.exception.CategoriesRequestInvalidException;
import com.barclays.categories.exception.SystemException;
import com.barclays.categories.model.CategoriesResponse;
import com.barclays.categories.model.StatusBlock;

// write any exceptions in controller in this 
@ControllerAdvice
@ResponseBody
public class CategoriesControllerAdvice {

	private CategoriesResponse buildCategoryResponseBlock(String respCode, String respMsg) {
		CategoriesResponse categoriesResp = new CategoriesResponse();

		StatusBlock statusBlk = new StatusBlock();
		statusBlk.setRespCode(respCode);
		statusBlk.setRespMsg(respMsg);

		categoriesResp.setStatus(statusBlk);
		return categoriesResp;
	}

	@ExceptionHandler(value = CategoriesRequestInvalidException.class) // So in your layered arch, exceptions bubble up
																		// from
	// CategoriesController ->CategoriesRTequestValidator-> DispatcherServlet →
	// ControllerAdvice automatically.
	public CategoriesResponse handleException(CategoriesRequestInvalidException crie)

	{
		System.out.println("entered CategoriesControllerAdvice ");

		System.out.println("exit CategoriesControllerAdvice CategoriesRequestInvalidException");
		return buildCategoryResponseBlock(crie.getRespCode(), crie.getRespMsg());

	}

	@ExceptionHandler(value = BusinessException.class)
	// CheckedException path
	// CategoriesDaoImpl ->CategoriesServiceImpl->CategoriesController ->
	// CategoriesControllerAdvice
	public CategoriesResponse handleDataError(BusinessException be) {

		System.out.println("exit CategoriesControllerAdvice BusinessException");
		return buildCategoryResponseBlock(be.getRespCode(), be.getRespMsg());

	}

	@ExceptionHandler(value = SystemException.class)
	// CheckedException path
	// CategoriesDaoImpl ->CategoriesServiceImpl->CategoriesController ->
	// CategoriesControllerAdvice
	public CategoriesResponse handleException(SystemException se) {
		System.out.println("exit CategoriesControllerAdvice SystemException");
		return buildCategoryResponseBlock(se.getRespCode(), se.getRespMsg());

	}

	@ExceptionHandler(value = Exception.class)

	public CategoriesResponse handleGenericException(Exception e) {

		System.out.println("exit CategoriesControllerAdvice SystemException");
		return buildCategoryResponseBlock("8888", "Unknown error from Server");

	}

}
