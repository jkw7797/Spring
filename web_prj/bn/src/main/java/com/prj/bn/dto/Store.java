package com.prj.bn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
	private int storeId;
	private String storeName;
	private String storeNumber;
	private String classification;
	private String homepage;
	private String floor;
	private String address;
	private int openingHour;
	private int closingHour;
	private String closedDay;
	private String delivery;
}