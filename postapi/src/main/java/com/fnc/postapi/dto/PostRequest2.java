package com.fnc.postapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequest2{
    private String account;
    private String email;
    private String address;
    private String password;
	
	@JsonProperty("phone_number")//front에서는 스네이크 룰을 선호함
	private String phoneNumber;

	
	

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "{" +
			" account='" + getAccount() + "'" +
			", email='" + getEmail() + "'" +
			", address='" + getAddress() + "'" +
			", password='" + getPassword() + "'" +
			", phoneNumber='" + getPhoneNumber() + "'" +
			"}";
	}

}