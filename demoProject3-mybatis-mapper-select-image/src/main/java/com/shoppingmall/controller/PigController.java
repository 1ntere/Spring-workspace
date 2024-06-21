package com.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shoppingmall.dto.Pig;
import com.shoppingmall.service.PigService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PigController {

	@Autowired
	private PigService pigService;
	
	@GetMapping("/")
	public String getAllPigs(Model model) {
		List<Pig> pigs = pigService.getAllPigs();
		model.addAttribute("pigs", pigs);
		return "index";
	}
	
	@GetMapping("/pigDetail")
	public String getPigById(Model model) {
		List<Pig> pigs = pigService.getAllPigs();
		model.addAttribute("pigs", pigs);
		return "index";
	}
	
	//application.properties에 error 경로를 지정하고 설정에서 지정된 경로를 찾아 출력
	/*
	@RequestMapping("/error")
	public String getError() {
		return "error";
	}
	*/
	
	@GetMapping("/pigDetail/{pig_id}")
	public String getCompanyById(Model model, @PathVariable int pig_id) {
		Pig pig = pigService.getPigById(pig_id);
		model.addAttribute("pig", pig);
		return "pigDetail";
	}
	
	/* 돼지 정보를 올릴 수 있는 주소로 이동하는 GetMapping 작성하기 */
	@GetMapping("/imgUpload")
	          // /imgUpload : index.html의 32번째 줄
	          //              	<a href="/imgUpload">돼지이미지와 상세정보 업로드</a>
	          //              	a태그에 연결한 주소
	          //              	html 파일과 java 파일이 만나는 공간
	          //              /upload-page-pig로 변경 가능
	          //              index.html의 32번째 줄
	          //              	<a href="/imgUpload">돼지이미지와 상세정보 업로드</a>도
	          //              	<a href="/upload-page-pig">돼지이미지와 상세정보 업로드</a>로 바꿔줘야 함
	public String uploadForm(Model model) {
		model.addAttribute("p", new Pig());
			//DB에 올릴 수 있는 공간을 만들어줌
		return "imgUpload";
			  //imgUpload : html 이름
	}
	
	/* 돼지 정보를 DB에 업로드하는 PostMapping */
	@PostMapping("/upload")
	public String uploadPig(
			//@RequestParma을 이용하여 파일을 하나씩 가져오겠다 설정
			@RequestParam("pig_name") String pig_name, 
			@RequestParam("pig_age") int pig_age, 
			@RequestParam("pig_image_path") MultipartFile file,
			Model model) {
		pigService.uploadPig(pig_name, pig_age, file);
		log.info("pigUpload 확인");
		
		//return "index";
			//upload 완료되면 메인페이지로 가서 제대로 등록되었는지 확인
		return "redirect:/";
		/*
		redirect:/ 와 index의 차이점
		
		redirect:/	 : 사용자가 새로운 url로 다시 요청하도록 지시
					   react로 작성하고 나서 값을 전달할 때 주로 사용할 예정
		index		 : 그냥 index.html 파일로 이동
		*/
	}
}
