package com.fnc.postapi.dto;

public class PostRequest{
    private String account;
    private String email;
    private String address;
    private String password;

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


    @Override
    public String toString() {
        return "{" +
            " account='" + getAccount() + "'" +
            ", email='" + getEmail() + "'" +
            ", address='" + getAddress() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }

}