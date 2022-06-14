package com.peter.myport.friend;

import java.util.List;

public interface FriendMapper {
	
	
	public abstract int insertFriend(Friend f);
	
	
	public abstract List<Friend> selectSummitedList(Friend f);
	
	
	public abstract int acceptFriend(Friend f);
	
	
	public abstract List<Friend> selectFriend(Friend f);
}
