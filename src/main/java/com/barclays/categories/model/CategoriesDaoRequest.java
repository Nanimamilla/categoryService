package com.barclays.categories.model;

import lombok.Data;

//for integration layer1 dao CategoriesDaoImpl
@Data // Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString
		// @EqualsAndHashCode.
public class CategoriesDaoRequest {

	private String cardNum;
	private String clientId;
	private String ChannelId;

}
