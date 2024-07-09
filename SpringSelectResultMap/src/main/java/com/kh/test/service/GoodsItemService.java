package com.kh.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.dto.GoodsItem;
import com.kh.test.mapper.GoodsItemMapper;

@Service
public class GoodsItemService {
	@Autowired
	/*
	@Autowired는 아래 코드와 같은 기능
	public GoodsItemService (GoodsItemMapper goodsItemMapper) {
		this.goodsItemMapper = goodsItemMapper;
	}
	*/
	private GoodsItemMapper goodsItemMapper;
	
	public boolean existsByName(String itemName) {
		//Integer로 맞춘 후 Integer를 boolean으로 변경해서 전달할 예정
		//Integer count = goodsItemMapper.existsByName(itemName); -> resultMap을 사용하지 않을 때 하는 방식
		GoodsItem count = goodsItemMapper.existsByName(itemName); //resultMap을 사용한 방식
		Integer totalCount = count != null ? count.getItemCount() : 0;
	  //Integer totalCount = 참인지 거짓인지    ? true이고 null이 아닐 때  : false이고 null일 때;
		return totalCount != null && totalCount > 0; //true라고 전달할 예정 return = boolean
		
		//return goodsItemMapper.existsByName(itemName);
		/*
		★ 오류가 발생한 코드
		return goodsItemMapper.existsByName(itemName);
		★ 오류 코드
		Type mismatch: cannot convert from Integer to boolean
		★ 원인
		Mapper에서는 Integer로 작성하고, Service에서 반납할 때는 boolean을 사용하기 때문에 타입이 맞지 않음
		★ 해결방안
		Mapper랑 Service 모두 Integer 나 int로 작성하거나
		Mapper랑 Service 모두 boolean으로 작성하기
		*/
	}
}