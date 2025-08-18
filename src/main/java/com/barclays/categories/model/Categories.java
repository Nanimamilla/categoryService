package com.barclays.categories.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data // Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString
		// @EqualsAndHashCode.
public class Categories {
	private String id;
	private String name;
	private String desc;
	private String expDate;
	private String type;
	private String status;

}
