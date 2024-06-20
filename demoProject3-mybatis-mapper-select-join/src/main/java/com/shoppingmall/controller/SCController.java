package com.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shoppingmall.dto.SC;
import com.shoppingmall.service.SCservice;

import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SCController {
	@Autowired
	private SCservice scService;
	
	@GetMapping("/") // "/" : index의 기본주소는 "/", 특정한 기능을 널지 않으면
	                 //       /(기본주소)가 index를 바라보기 때문에 작성을 생략해도 되지만
	                 //       특정한 값을 가져오거나
	                 //       /(기본주소)가 index 이외에 다른 html 파일을 바라볼 때는
	                 //       GetMapping()에 "/" 대신하여 기능이나 HTML파일을 작성해줌
	public String getAllSC(Model model) {
		List<SC> sc = scService.getAllSC();
		log.info("모든 DB값 가져오는지 확인하기" + sc);
		/*
		★ 오류 발생
		                                 //sc
		★ 문제가 발생한 모습
		모든 DB값 가져오는지 확인하기[com.shoppingmall.dto.SC@435ab552,
		                      com.shoppingmall.dto.SC@7f92a252,
		                      com.shoppingmall.dto.SC@7606bce9,
		                      com.shoppingmall.dto.SC@324063d7]
		
		★ 원인
		DTO에서 @ToString어노테이션을 이용하지 않으면 DB에서 가져오는 주소값만 보여주기 때문에
		값을 제대로 가지고 오는지 확인하길 원한다면 DTO에 @ToString어노테이션 추가
		
		만약에 값을 제대로 가지고 오지 않는다면 NULL을 출력함
		
		★ 문제 해결 방법
		DTO에 @ToString어노테이션 추가
		
		★ 해결한 뒤 출력 확인
		모든 DB값 가져오는지 확인하기[SC(snack_id=0, snack_name=오에스, price=1500, company_name=햇에제과, company_phone=02-1234-5678),
		                      SC(snack_id=0, snack_name=칸조, price=1220, company_name=햇에제과, company_phone=02-1234-5678),
		                      SC(snack_id=0, snack_name=배배로, price=1100, company_name=롯에제과, company_phone=02-2345-6789),
		                      SC(snack_id=0, snack_name=조고파이, price=2000, company_name=롯에제과, company_phone=02-2345-6789)]
		 */
		model.addAttribute("snackAndCompany",sc);
		                 //"snackAndCompany" : index.html의 28번째 줄
		                 //                    <tr th:each="sac : ${snackAndCompany}">
		return "index";
	}
	
	@GetMapping("/snack/{snack_id}")
	                  //{snack_id} : 주소값이 변하는 변수는 {}로 감싸줌
	public String getSnackById(Model model, @PathVariable int snack_id) {
	//주소값으로 id 숫자를 가져와서 주소값에 지정된 id 숫자와 일치하는 DB 값을 모두 가져오기
		SC sc = scService.getSnackById(snack_id);
		//주소값으로 설정한 id를 받아오고 SCService에 전달해서 DB에서 꺼내오기 작업
		model.addAttribute("snack", sc);
		return "snackDetail";
	}

	@GetMapping("/company/{company_id}")
	public String getCompanyById(Model model, @PathVariable int company_id) {
		SC sc = scService.getCompanyById(company_id);
		model.addAttribute("company", sc);
		return "companyDetail";
	}
}
