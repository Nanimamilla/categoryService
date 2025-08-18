package com.barclays.categories.model;

import java.util.List;

import lombok.Data;

//for  integration layer1 dao CategoriesDaoImpl
@Data // Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString
		// @EqualsAndHashCode.
public class CategoriesDaoResponse {

	private String dbRespCode;
	private String dbRespMsg;
	private List<CategoriesDao> categoriesDao;

}
