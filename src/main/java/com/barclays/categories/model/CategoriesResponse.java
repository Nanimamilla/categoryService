package com.barclays.categories.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

//for service layer CategoriesServiceImpl
@Data // Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString
		// @EqualsAndHashCode.

@JsonInclude(value = Include.NON_NULL) // remove null values in resonse
public class CategoriesResponse {
	private StatusBlock status;
	private List<Categories> categories;

}
