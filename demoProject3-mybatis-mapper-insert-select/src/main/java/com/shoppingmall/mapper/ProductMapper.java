package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shoppingmall.dto.Goods;

@Mapper
public interface ProductMapper {
	void insertProduct(Goods goods);
	
	//상품을 모두 가져올 때는 List나 Array 배열 사용
	List<Goods> getAllProduct();
	//List : List로 상품을 진열하겠다
}
