package com.example.demo.controller.blog;
                       //controller.blog : controller 폴더 밑에 blog 폴더를 생성해서
                       //                  블로그 관련 컨트롤러를 작성

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("blog")
public class BlogController {
	@GetMapping("index") // blog/index
	public String blogMainMethod() {
		return "blog/blog-index";
	}
	
	@GetMapping("board") // blog/board
	/*
	10번째줄 @RequestMapping("blog")를 지우고
	@GetMapping("blog-board")를 하면
	blog-index.html에서 17번째 줄
	<li><a href="/blog-board">게시판</a></li>로 바꿔주면 됨
	 */
	//
	//
	public String blogBoardMethod() {
		return "blog/blog-board";
	}
}
