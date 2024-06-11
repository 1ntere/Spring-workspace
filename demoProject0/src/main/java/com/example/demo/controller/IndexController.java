package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller // 요청/응답을 받는 표시, Spring에서 Controller로 작성하라 명시되어 있음
//Bean : Spring이 만들고 관리하는 표시
@Slf4j //각 메서드 이동할 때 마다 log.info를 사용해서 위치 이동 Console에 출력하기
public class IndexController {
	@GetMapping("cafe/cafe_index")//back과 front가 만나는 위치
	public String cafeMainMethod() {
		log.info("cafe index로 이동");
		return "cafe/cafe_index";//html 파일의 위치
	}

	@GetMapping("cafe/cafe_board")
	public String cafeBoardMethod() {
		log.info("cafe board로 이동");
		return "cafe/cafe_board";
	}
	
	//blog-index로 이동하는 GetMapping 만들기
	@GetMapping("blog/blog-index")
	public String blogMainMethod() {
		log.info("blog index로 이동");
		return "blog/blog-index";
	}
	
	@GetMapping("blog/blog-board")
	public String blogBoardMethod() {
		log.info("blog board로 이동");
		return "blog/blog-board";
	}
	

}
