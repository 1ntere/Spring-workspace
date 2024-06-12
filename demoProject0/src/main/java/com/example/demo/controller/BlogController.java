package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.BlogDTO;

import lombok.extern.slf4j.Slf4j;

//어노테이션(@) 이용해서, Controller, RequestMapping, Slf4j 설정
@Controller
@RequestMapping("blog")
@Slf4j
public class BlogController {
	//어노테이션(@) 이용해서, PostMapping("comment")만들고
	//@RequestParam 이용해서 blog-index.html 파일에 작성한
	//commentName, commentOpinion 작성하기
	//required=true
	//return blog-index
	@PostMapping("comment")
	public String blogComment(/*@ModelAttribute*/ BlogDTO blogDTO
			/*
			원래는 @ModelAttribute 대신 @RequestParam를 사용한 아래 코드를 사용했었음
				@RequestParam("commentName") String commentName,
			                               //String commentName : @RequestParam으로 가져온
			                               //                     commentName을 지정할
                                           //                     자료형 String과 변수명 commentName
			    @RequestParam("commentOpinion") String commentOpinion
			*/
			){
		BlogDTO bd = new BlogDTO();
		bd.getCommentName();
		bd.getCommentOpinion();
		
		log.info("블로그 코멘트가 제대로 작성되었는지 확인");
		log.info("bd에 작성한 내용 보기" + bd.toString());
		
		//log.debug("commentName : " + commentName);
		//log.debug("commentOpinion : " + commentOpinion);
		log.info("블로그 메인으로 이동하기");
		return "redirect:/blog/blog-index";
		      //redirect:/blog/blog-index : blog-index로 돌아가기
	}
}
