package com.barclays.categories.model;

import lombok.Data;

//for integration layer2 card service
@Data // Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString
		// @EqualsAndHashCode.
public class CardServiceClientReq {
	// channel id is not required.
	private String cardNum;
	private String clientId;
	private String reqId;
	private String msgTs;

}
