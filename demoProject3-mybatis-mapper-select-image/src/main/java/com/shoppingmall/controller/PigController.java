package com.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoppingmall.dto.Pig;
import com.shoppingmall.service.PigService;

@Controller
public class PigController {

	@Autowired
	private PigService pigService;
	
	@GetMapping("/")
	public String getAllPigs(Model model) {
		List<Pig> pigs = pigService.getAllPigs();
		model.addAttribute("pigs", pigs);
		return "index";
	}
	
	@GetMapping("/pigDetail")
	public String getPigById(Model model) {
		List<Pig> pigs = pigService.getAllPigs();
		model.addAttribute("pigs", pigs);
		return "index";
	}
	
	//application.properties에 error 경로를 지정하고 설정에서 지정된 경로를 찾아 출력
	/*
	@RequestMapping("/error")
	public String getError() {
		return "error";
	}
	*/
	
	@GetMapping("/pigDetail/{pig_id}")
	public String getCompanyById(Model model, @PathVariable int pig_id) {
		Pig pig = pigService.getPigById(pig_id);
		model.addAttribute("pig", pig);
		return "pigDetail";
	}
}
