package com.peter.myport.sns;

import java.util.List;

public interface SnsMapper {
	
	public abstract int insertSns(Sns s);
	
	public abstract List<Sns> selectSns();
}
