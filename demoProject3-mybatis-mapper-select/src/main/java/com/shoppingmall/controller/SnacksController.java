package com.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shoppingmall.dto.Snacks;
import com.shoppingmall.service.SnacksService;

@Controller
public class SnacksController {
	@Autowired //SnacksService에 작성된 모든 기능을 활용하겠다.
	private SnacksService snacksService;
	
	@GetMapping("/allSnack")//index.html에서 작성한 주소
	public String getAllSnacks(Model model) {
		List<Snacks> snackList = snacksService.getAllSnacks(); 
				               //snacksService.getAllSnacks() : Snack서비스에서 추가적인 서비스 기능으로 작성한 메서드 가져오기
		model.addAttribute("snackList", snackList);
		return "snackList";
	}
}
