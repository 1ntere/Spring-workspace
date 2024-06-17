package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Drinks;
import com.example.demo.service.DrinksService;

@Controller
public class DrinksController {
	@GetMapping("/drinksregister")
	public String registerForm(Model model) {
		model.addAttribute("drinks", new Drinks());
		return "index";
	}
	
	@Autowired
	private DrinksService drinksService;
	
	@PostMapping("/drinksregister")
	public String insertDrinks(Drinks drinks, Model model) {
		drinksService.insertDrinks(drinks);
		model.addAttribute("msg", "음료수가 성공적으로 기입되었습니다.");
		return "registerSuccess";
	}
}
