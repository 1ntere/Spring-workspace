package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.CafeDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("cafe")
@Slf4j
public class CafeController {
	
	
	/*
	방법 2	@RequestParam
	@PostMapping("comment")
	public String cafeMainComment(@RequestParam("cafeCommentName") String cafeCommentName,
			                      @RequestParam("cafeCommentOpinion") String cafeCommentOpinion) {
		log.info("cafe 코멘트가 제대로 달렸는지 확인");
		
		log.debug("cafeCommentName : " + cafeCommentName);
		log.debug("cafeCommentOpinion : " + cafeCommentOpinion);
		log.info("cafe index로 돌아가기");
		return "redirect:/cafe/cafe_index";
	}
	*/
	
	/*
	방법 4	@ModelAttribute
	*/
	@PostMapping("comment")
	public String cafeMainComment(CafeDTO cafeDTO) {
		CafeDTO cd = new CafeDTO();
		
		cd.getCafeCommentName();
		cd.getCafeCommentOpinion();
		cd.setCafeCommentName(null);
		cd.setCafeCommentOpinion(null);
		
		log.info(cafeDTO.toString());
		log.info("cafe index로 돌아가기");
		return "redirect:/cafe/cafe_index";
	}
}
