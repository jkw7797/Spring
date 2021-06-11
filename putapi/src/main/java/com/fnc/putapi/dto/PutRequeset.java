package com.fnc.putapi.dto;

import java.util.List;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PutRequeset {
    private String name;
    private int age;
    
    private List<car> carList;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<car> getCarList() {
		return this.carList;
	}

	public void setCarList(List<car> carList) {
		this.carList = carList;
	}


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", carList='" + getCarList() + "'" +
            "}";
    }
    

}
