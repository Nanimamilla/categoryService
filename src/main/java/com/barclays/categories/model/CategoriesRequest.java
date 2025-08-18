package com.barclays.categories.model;

import lombok.Data;

//for service layer CategoriesServiceImpl
@Data // Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString
		// @EqualsAndHashCode.
public class CategoriesRequest {

	private String cardNum;
	private String clientId;
	private String ChannelId;
	private String reqId;
	private String msgTs;

}
