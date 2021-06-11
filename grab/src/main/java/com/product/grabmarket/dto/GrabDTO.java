package com.product.grabmarket.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder=true)
public class GrabDTO {

	private String name;
	private String price;
	private String seller;
	private String imageUrl;
	
	public GrabDTO() {
	}
	public GrabDTO(String name, String price,String seller, String imageUrl) {
		setName(name); 
		setPrice(price);
		setSeller(seller);
		setImageUrl(imageUrl);
	}
}
