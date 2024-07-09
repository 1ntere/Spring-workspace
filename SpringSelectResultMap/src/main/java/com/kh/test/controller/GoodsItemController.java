package com.kh.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.test.service.GoodsItemService;

@RestController
public class GoodsItemController {
	@Autowired
	private GoodsItemService goodsItemService;
	
	@GetMapping("/gooditem/check")
	public Map <String, Object> existsByName(@RequestParam String name) {
		//만약에 상품명이 조회가 된다면 이미 존재하는 상품명입니다. 만들기
		
		boolean isCheck = goodsItemService.existsByName(name);
		Map <String, Object> res = new HashMap<String, Object>();
		   //String : name, Object : isCheck

		res.put("isCheck", isCheck);
		return res; //Map으로 전달된 key, value를 다시 html 파일에서 중복체크 전달
	  //return res; : ajax는 html파일 return을 작성하지 않음
	  //              왜냐하면 html파일을 불러오는 것이 아니라
	  //              html파일의 일부분만 설정하는 것이기 때문
	}
}
