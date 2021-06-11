package com.fnc.putapi.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class car {
    private String name;
    private String carNumber;

    
    // public car(){
    // }// 기본생성자가 아닌 생성자를 만들면 에러가 남

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarNumber() {
		return this.carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", carNumber='" + getCarNumber() + "'" +
            "}";
    }

}
