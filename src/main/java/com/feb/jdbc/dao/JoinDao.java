package com.feb.jdbc.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public interface JoinDao {
	
	public int join(HashMap<String, String> params);
	
}
