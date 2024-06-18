package com.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shoppingmall.dto.Goods;
import com.shoppingmall.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j //log 이용해서 DB에서 전달해준 값이 잘 출력되는지 확인
public class GoodsController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/register-product")
	public String insertProduct(Goods goods, Model model) {
		productService.insertProduct(goods);
		List<Goods> productList = productService.getAllProduct();
		model.addAttribute("productList", productList);
		model.addAttribute("msg", "상품이 성공적으로 등록되었습니다.");
		return "productList";
	}
	
	@GetMapping("/product-list")
	public String gettAllProduct(Model model) {
		List<Goods> productList = productService.getAllProduct();
		log.info("상품전체목록 : " + productList);
		model.addAttribute("productList", productList);
		return "productList";
	}

}
