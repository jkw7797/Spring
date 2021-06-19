package com.prj.bn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
	private String storeId;
	private String storeName;
	private String storeNumber;
	private String classification;
	private String homepage;
	private String floor;
	private String address;
	private String openingHour;
	private String closingHour;
	private String closedDay;
	private String delivery;
	private String foodName;
	private String foodPrice;
}
