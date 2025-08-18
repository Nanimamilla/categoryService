package com.barclays.categories.model;

import lombok.Data;

@Data // Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString
		// @EqualsAndHashCode.
public class CategoriesDao {
	private String id;
	private String name;
	private String desc;
	private String expDate;
	private String type;
	private String status;

}
