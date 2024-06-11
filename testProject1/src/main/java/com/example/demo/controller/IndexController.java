package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/test")
  //@ : Annotation
  //@RequestMapping : 기본으로 return 할 때 html 파일을 출력하겠다는 설정
	public String 테스트페이지연결메서드() {
		System.out.println("test 페이지로 제대로 연결되었는지 확인 출력 메서드");
		return "test";
		      //test : src/main/resources/templates/test.html 로 이동하겠다.
		             //src/main/resources : Class의 path
		                                //templates : 기본 경로 뒤에 붙은 templates 폴더는
		                                //            보통 html 파일을 담는 공간
		                                          //test.html : html 파일 열기
	}
}
