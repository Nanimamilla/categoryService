package com.barclays.categories.model;

import lombok.Data;

@Data // Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString
		// @EqualsAndHashCode.
public class StatusBlock {

	private String respCode;
	private String respMsg;

}
