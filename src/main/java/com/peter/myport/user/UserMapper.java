package com.peter.myport.user;

public interface UserMapper {

	
	public abstract int insertUser(User u);
	
	public abstract User selectLogin(User u);
	
	public abstract int updateUser(User u);
	
	public abstract int deleteUser(User u);
}
