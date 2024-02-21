package com.feb.jdbc.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feb.jdbc.dao.JoinDao;

@Service
public class JoinService {

	@Autowired
	private JoinDao joinDao;
	
	public int join(HashMap<String, String> params) {
		return joinDao.join(params);
	}
}
