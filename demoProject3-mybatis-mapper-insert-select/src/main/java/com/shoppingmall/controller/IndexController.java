package com.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shoppingmall.dto.Goods;

@Controller
public class IndexController {
	/*index.html 주소로 이동할 때 사용하는 GetMapping작성*/
	@GetMapping("/productRegister")
	//index.html의 13번째 줄
	//<a href="/productRegister">등록하기</a>와 동일해야한다.
	
	public String goodsRegister(Model model) {
		model.addAttribute("goods", new Goods());
		return "productRegister";
	}

}
