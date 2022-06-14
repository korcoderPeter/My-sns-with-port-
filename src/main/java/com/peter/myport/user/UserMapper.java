package com.peter.myport.user;

import java.util.List;

public interface UserMapper {

	
	public abstract int insertUser(User u);
	
	public abstract User selectLogin(User u);
	
	public abstract int updateUser(User u);
	
	public abstract int deleteUser(User u);
	
	
	public abstract List<User> selectAllUser();
	
	
	public abstract User selectUserDetail(User u);
}
