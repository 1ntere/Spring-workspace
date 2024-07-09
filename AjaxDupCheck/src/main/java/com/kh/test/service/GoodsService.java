package com.kh.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.mapper.GoodsMapper;

@Service
public class GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	
	public boolean getGoods(String item_name) {
		Integer count = goodsMapper.getGoods(item_name);
		
		return count != null && count > 0;
		     //count는 null이 아니다 : 0 또는 1 이상, -1
		                      //count가 0보다 클 때 반환
	}
}