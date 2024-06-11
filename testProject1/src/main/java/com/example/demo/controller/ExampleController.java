package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {
	
	@GetMapping("example")
  //@ : Annotation
  //@GetMapping : 기본으로 return 할 때 html 파일을 출력하겠다는 설정
	public String exampleMethod() {
		System.out.println("/example 요청 받았는지 확인");
		return "example";
	}
}
