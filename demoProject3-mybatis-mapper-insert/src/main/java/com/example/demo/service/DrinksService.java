package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Drinks;
import com.example.demo.mapper.DrinksMapper;

@Service
public class DrinksService {
	@Autowired
	private DrinksMapper drinksMapper;
	
	public void insertDrinks(Drinks drinks) {
		drinksMapper.insertDrinks(drinks);
	}
}
