package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


//index라는 이름은 기본으로 바라보는 페이지명
//보통 처음 맨 앞에 있는 페이지 명으 index로 설정
@Controller
@Slf4j
public class IndexController {
	//1. test 메서드를 이용해서 test.html로 무사히 이동하는지 확인하는 메서드 작성
	@RequestMapping("test")
	public String testMethod() {
		log.info("테스트 페이지 이동 확인");
		return "test";
	}
	@RequestMapping("home")
	public String homeMethod() {
		log.info("홈페이지로 이동 확인");
		return "index";
		      //index : RequestMapping에 작성한 이름(home)과
		      //        return에 작성한 이름(index)이 달라도 됨
	}
}
