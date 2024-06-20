package com.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmall.dto.Pig;
import com.shoppingmall.mapper.PigMapper;

@Service
public class PigService {
	@Autowired
	private PigMapper pigMapper;
	
	public List<Pig> getAllPigs() {
		return pigMapper.getAllPigs();
	}
	
	public Pig getPigById(int pig_id) {
		return pigMapper.getPigById(pig_id);
	}
}
