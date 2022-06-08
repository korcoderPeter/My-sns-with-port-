package com.peter.myport.user;

public class User {
	private String username;
	private String password;
	private String name;
	private String userbirth;
	private String address;
	private String email;
	private String phonenumber;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserBirth() {
		return userbirth;
	}

	public void setUserBirth(String userBirth) {
		this.userbirth = userBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phonenumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phonenumber = phoneNumber;
	}

	public User(String userName, String password, String name, String userBirth, String address, String email,
			String phoneNumber) {
		super();
		this.username = userName;
		this.password = password;
		this.name = name;
		this.userbirth = userBirth;
		this.address = address;
		this.email = email;
		this.phonenumber = phoneNumber;
	}

}
