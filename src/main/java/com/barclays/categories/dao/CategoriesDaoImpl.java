package com.barclays.categories.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.barclays.categories.exception.BusinessException;
import com.barclays.categories.exception.SystemException;
import com.barclays.categories.model.CategoriesDao;
import com.barclays.categories.model.CategoriesDaoRequest;
import com.barclays.categories.model.CategoriesDaoResponse;

@Component

public class CategoriesDaoImpl implements ICategoriesDao {

	@Override
	public CategoriesDaoResponse getCategories(CategoriesDaoRequest categoriesReq)
			throws BusinessException, SystemException {
		// TODO: use Log4J later for this

		System.out.println("Entered into Dao method");
		CategoriesDaoResponse daoResp = new CategoriesDaoResponse();
		// Todo =>Hatrdcoded data remove later for testing
		// test0
		String dbRespCode = "0";
		String dbRespMsg = "Success";
//		

		// Test1 Business Exception
//		String dbRespCode = "102";
//		String dbRespMsg = "DataBase Timeout";

		// Test2 SystemException
//		String dbRespCode = "333";
//		String dbRespMsg = "DataBase no data found";

		// Test3 GenericException
//				String dbRespCode = "33";
//				String dbRespMsg = "DataBase no data found";

		// TODO :hardcoding temperoryly later,remove and write the dao code to
		// communicate with DB and get the list of categories
//prepare request for dao call db and get Response.
		// System.out.println("daoResp data0"+daoResp);
		try {

			if ("0".equals(dbRespCode)) {

				List<CategoriesDao> categoriesDaoList = new ArrayList<CategoriesDao>();

				CategoriesDao categoriesDao1 = new CategoriesDao();
				categoriesDao1.setId("111");
				categoriesDao1.setName("Electronics");
				categoriesDao1.setType("catoo1");
				categoriesDao1.setStatus("active");
				categoriesDao1.setExpDate("12/31/2025");
				categoriesDao1.setDesc("good");

				CategoriesDao categoriesDao2 = new CategoriesDao();
				categoriesDao2.setId("222");
				categoriesDao2.setName("LifeStyle");
				categoriesDao2.setType("catoo1");
				categoriesDao2.setStatus("active");
				categoriesDao2.setExpDate("12/31/2025");
				categoriesDao2.setDesc("good");

				CategoriesDao categoriesDao3 = new CategoriesDao();
				categoriesDao3.setId("333");
				categoriesDao3.setName("Entertainment");
				categoriesDao3.setType("catoo1");
				categoriesDao3.setStatus("active");
				categoriesDao3.setExpDate("12/31/2025");
				categoriesDao3.setDesc("good");

				CategoriesDao categoriesDao4 = new CategoriesDao();
				categoriesDao4.setId("444");
				categoriesDao4.setName("Jewel");
				categoriesDao4.setType("catoo1");
				categoriesDao4.setStatus("active");
				categoriesDao4.setExpDate("12/31/2025");
				categoriesDao4.setDesc("good");

				CategoriesDao categoriesDao5 = new CategoriesDao();
				categoriesDao5.setId("555");
				categoriesDao5.setName("Travel");
				categoriesDao5.setType("catoo1");
				categoriesDao5.setStatus("active");
				categoriesDao5.setExpDate("12/31/2025");
				categoriesDao5.setDesc("good");
				categoriesDaoList.add(categoriesDao1);
				categoriesDaoList.add(categoriesDao2);
				categoriesDaoList.add(categoriesDao3);
				categoriesDaoList.add(categoriesDao4);
				categoriesDaoList.add(categoriesDao5);

				daoResp.setCategoriesDao(categoriesDaoList);
				daoResp.setDbRespCode(dbRespCode);
				daoResp.setDbRespMsg(dbRespMsg);

				System.out.println("daoResp data3" + daoResp);
			} else if ("100".equals(dbRespCode) || "101".equals(dbRespCode) || "102".equals(dbRespCode)) {
				System.out.println("daoRes BusinessException" + daoResp);
				throw new BusinessException(dbRespCode, dbRespMsg);

			}

			else if ("333".equals(dbRespCode) || "444".equals(dbRespCode) || "555".equals(dbRespCode)) {
				System.out.println("daoRes SystemException" + daoResp);
				throw new SystemException(dbRespCode, dbRespMsg);

			}
			System.out.println("exit daoResp data success " + daoResp);

		}
		// inorder to print these exceptions here itself use try and catch and print.
		// But also to let know where its called layer (Service layer here) know these
		// exceptions happended we need to rethrow it.

		// Also note that since these are checked Exceptions,
		// it would sow errors in where it is called (service Layer),
		// use throws there toot0o control layer and use throws there to controller
		// Advice
		catch (BusinessException be) {
			System.out.println(be);
			throw be;

		} catch (SystemException se) {
			System.out.println(se);
			throw se;
		}

		System.out.println("exitDao method");
		return daoResp;
	}

}
