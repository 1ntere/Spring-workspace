package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExampleController {
	@RequestMapping("/example")
	public String exampleMethod() {
		System.out.println("/example 요청 받았는지 확인");
		return "example";
	}
}
