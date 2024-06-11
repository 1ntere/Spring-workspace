package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("param")
@Slf4j
public class ParameterController {
	@GetMapping("main")
	public String paramMain() {
		return "param/parma-main";
	}
	
	@PostMapping("test1")
	public String paramTest1(HttpServletRequest req) {
		String inputName = req.getParameter("inputName");
		String inputAddress = req.getParameter("inputAddress");
		int inputAge = Integer.parseInt(req.getParameter("inputAge"));
		
		log.info("시작했는지 확인");
		log.info("로그로 이름 확인하기" + inputName);
		log.info("로그로 나이 확인하기" + inputAge);
		log.info("로그로 주소 확인하기" + inputAddress);
		
		log.info("=================================");
		log.debug("로그로 이름 확인하기" + inputName);
		log.debug("로그로 나이 확인하기" + inputAge);
		log.debug("로그로 주소 확인하기" + inputAddress);
		
		return "redirect:/param/main";//작성 다 되면 메인으로 돌아가기
	}
}
