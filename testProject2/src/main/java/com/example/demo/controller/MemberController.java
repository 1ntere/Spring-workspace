package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("member")
@Slf4j
public class MemberController {
	
	@GetMapping("memberinfo")
	public String memberInfo(Model model) {
		MemberDTO mem = new MemberDTO();
		mem.setMemberName("000");
		mem.setMemberPhone("010-0000-0000");
		mem.setMemberAge(20);
		model.addAttribute("mem", mem);
		
		List<MemberDTO> memList = new ArrayList<>();
		memList.add(new MemberDTO("홍길동", "010-1111-1111", 10));
		memList.add(new MemberDTO("강영희", "010-2222-2222", 20));
		memList.add(new MemberDTO("박철수", "010-3333-3333", 30));
		model.addAttribute("memList", memList);
		
		log.info("들어왔는지 확인");
		log.debug("문제 없는지 확인");
		return "member/memberinfo";
		
		/*
		★ 에러 발생
		org.thymeleaf.exceptions.TemplateInputException: An error happened during template
		
		1. memberinfo.html 파일 이름이 정확한지 확인하기
		2. Member를 객체 이름으로 작성한 경우
			import java.lankg.reflect.Member;를 import
		3. 가장 좋은 방법은 2번처럼 Member를 객체 이름으로 작성하지 않고 MemberDTO로 정확하게 작성하기
		*/
	}
}
