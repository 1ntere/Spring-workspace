package com.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shoppingmall.dto.Company;
import com.shoppingmall.service.CompanyService;

@Controller
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/allCompany")
	public String getAllCompany(Model model) {
		List<Company> companyList = companyService.getAllCompany();
		model.addAttribute("companyList", companyList);
		return "companyList";
	}

}
