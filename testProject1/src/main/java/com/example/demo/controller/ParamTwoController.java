package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("param2")
@Slf4j
public class ParamTwoController {
	@PostMapping("test2")
	public String paramTwoTest(@RequestParam("snackName") String snackName, 
							   @RequestParam("snackCompany") String snackCompany, 
							   @RequestParam("snackPrice") int snackPrice, 
							   @RequestParam(value="snackLike", defaultValue="snackLike", required=false) String snackLike) {
		log.info(snackName);
		log.info(snackCompany);
		log.info("" + snackPrice);
		/*
		★ 오류가 발생한 코드
		log.info(snackPrice);
		★ info의 기본값은 String이므로
		int자료형인 snackPrice를 출력하려면 1. String으로 변환하거나
		2. ""를 활용하여 앞에 무언가 String을 작성해주어야 한다.
		★ 문제 해결한 코드
		log.info("" + snackPrice);
		*/
		log.info(snackLike);
		return "redirect:/param/main";
	}
	
	@PostMapping("likeSnackCompany")
	public String paramLikeSnackCompany(@RequestParam(value="likeSnack", required=false) String[] snackArr, 
			                            @RequestParam(value="likeCompany", required=false) List<String> companyList) {
		log.info("좋아하는 과자들 : " + Arrays.toString(snackArr));
		log.info("선호하는 회사들 : " + companyList);
		return "redirect:/param/main";
	}
}
