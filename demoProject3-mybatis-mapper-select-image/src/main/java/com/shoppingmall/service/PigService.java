package com.shoppingmall.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shoppingmall.dto.Pig;
import com.shoppingmall.mapper.PigMapper;

@Service
public class PigService {
	@Autowired
	private PigMapper pigMapper;
	
	public List<Pig> getAllPigs() {
		return pigMapper.getAllPigs();
	}
	
	public Pig getPigById(int pig_id) {
		return pigMapper.getPigById(pig_id);
	}
	
	//uploadPig
	public void uploadPig(String pig_name, int pig_age, MultipartFile file) {
		//파일 이름 가져온 다음
		String fileName = file.getOriginalFilename();
		System.out.println("file Name : " + fileName);
		
		//우리가 저장하고자 하는 파일 경로 설정
		//String uploadDir = "C:/Users/user1/Desktop/pig_img/";
		/*
		★ 오류가 발생한 코드
		String uploadDir = "C:/Users/user1/servlet_jsp_workspace/demoProject3-mybatis-mapper-select-image/src/main/resources/static/images";
		★ 원인
		맨 끝에 / 로 닫아주지 않으면 이미지가 static/images 안에 이미지가 저장되는 것이 아니라
		static 바로 밑에 생성되기 때문에 이미지가 보이지 않으므로 반드시 마지막에 /를 넣어줘야 함
		★ 문제 해결한 코드
		String uploadDir = "C:/Users/user1/servlet_jsp_workspace/demoProject3-mybatis-mapper-select-image/src/main/resources/static/images/";
		*/
		String uploadDir = "C:/Users/user1/servlet_jsp_workspace/demoProject3-mybatis-mapper-select-image/src/main/resources/static/images/";
		File imgFile = new File(uploadDir + fileName);
		
		//만약 이미지 파일을 저장하는 폴더가 존재하지 않을 경우 생성하는 코드
		if (!imgFile.exists() ) {
		  //!imgFile.exists() : 만약에 이미지 폴더가 존재하지 않을 때가 true
			imgFile.mkdirs();
		}
		
		try {
			file.transferTo(imgFile);//이미지를 폴더에 저장하는 코드
			
			//업로드 한 다음에 저장된 이미지 경로와 함께 돼지 정보를 저장하는 서비스를 작성
			Pig pig = new Pig();
			pig.setPig_name(pig_name);
			pig.setPig_age(pig_age);
			
			//만약에 파일 경로와 이름을 같이 저장하길 원한다면
			pig.setPig_image_path("/images/" + fileName);
			                    //"/images/" + fileName : data에 /images/파일명.jpg
			                    //파일 이름만 저장하길 원한다면 위 코드 대신 아래 코드를 사용
			                    //pig.setPig_image_path(fileName);
			
			pigMapper.uploadPig(pig);
			System.out.println("파일 업로드 Service를 성공적으로 완료했습니다.");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//나중에 이미지 업로드에서 파일 저장경로에 대한 함수만 따로 설정
}