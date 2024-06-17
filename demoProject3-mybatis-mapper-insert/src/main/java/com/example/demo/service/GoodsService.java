package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Goods;
import com.example.demo.mapper.GoodsMapper;

@Service
public class GoodsService {
	@Autowired //Autowired 어노테이션을 사용하지 않으면 
	           //Context xml 파일로
	           //Mapper위치와 Service 위치를 설정하는 xml 파일을 만들어줘야 함 
	private GoodsMapper goodsMapper;
	
	public void insertGoods(Goods goods) {
		goodsMapper.insertGoods(goods);
	}
}
