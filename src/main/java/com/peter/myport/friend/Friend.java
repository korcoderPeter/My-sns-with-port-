package com.peter.myport.friend;

public class Friend {

	private String summit_user;
	private String status;
	private String accept_user;
	
	
	public Friend() {
		// TODO Auto-generated constructor stub
	}


	public String getSummit_user() {
		return summit_user;
	}


	public void setSummit_user(String summit_user) {
		this.summit_user = summit_user;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getAccept_user() {
		return accept_user;
	}


	public void setAccept_user(String accept_user) {
		this.accept_user = accept_user;
	}


	public Friend(String summit_user, String status, String accept_user) {
		super();
		this.summit_user = summit_user;
		this.status = status;
		this.accept_user = accept_user;
	}
	
	
	
	
	
	
}
