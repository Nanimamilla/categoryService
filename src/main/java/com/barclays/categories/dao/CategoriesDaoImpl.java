package com.barclays.categories.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.barclays.categories.model.CategoriesDao;
import com.barclays.categories.model.CategoriesDaoRequest;
import com.barclays.categories.model.CategoriesDaoResponse;

@Component
public class CategoriesDaoImpl implements ICategoriesDao {

	@Override
	public CategoriesDaoResponse getCategories(CategoriesDaoRequest categoriesReq) {
		//TODO: use Log4J later for this
		
		System.out.println("Entered into Dao method");
		
		// TODO :hardcoding temperoryly later,remove and write the dao code to 
        //communicate with DB and get the list of categories

		CategoriesDaoResponse daoResp= new CategoriesDaoResponse();
		
		daoResp.setDbRespCode("0");
		daoResp.setDbRespMsg("success");
		
		List<CategoriesDao> categoriesDaoList= new ArrayList<CategoriesDao>();
		
		
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
		System.out.println("Entered into Dao method");
		return daoResp;
	}

}
