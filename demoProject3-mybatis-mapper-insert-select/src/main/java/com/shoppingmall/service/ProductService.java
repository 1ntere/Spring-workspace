package com.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmall.dto.Goods;
import com.shoppingmall.mapper.ProductMapper;

@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	public void insertProduct(Goods Goods) {
		productMapper.insertProduct(Goods);
	}
	
	//상품 DB에서 가져온 상품 목록들을 Controller에 전달해주기
	public List<Goods> getAllProduct() {
		return productMapper.getAllProduct();
	}
}
