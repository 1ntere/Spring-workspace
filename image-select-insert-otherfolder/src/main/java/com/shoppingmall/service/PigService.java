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
	/*
	@Autowired는 다음 코드와 같은 의미이다.
	
	public PigService(PigMapper pigMapper) {
		this.pigMapper = pigMapper;
	}
	
	Service에서 추가적으로 수정된 데이터가 Mapper를 통해 DB에 들어가고
	DB에서 가져온 sql에 Service에서 추가적으로 수정을 진행한 다음 Controller에 전달하거나 전달 받기
	*/
	
	//1. 돼지 정보 전체 리스트 -> List <Pig>
	public List<Pig> getAllPigs() {
		return pigMapper.getAllPigs();
	}
	//2. 돼지 정보 하나만 가져오기 -> DTO Pig
	public Pig getPigById(int pig_id) {
		return pigMapper.getPigById(pig_id);
	}
	//3. 돼지 정보 DB에 업로드하기 -> void (Pig)
	//public void uploadPig(Pig pig) {}
	//	-> 돼지 정보를 저장할 때 경로나 이름 중에서 아무것도 변경할 게 없을 때 사용
	public void uploadPig(String pig_name, int pig_age, MultipartFile file) {
		//만약에 파일 이름을 저장하길 원한다면
		//이미지 업로드 할 때 임시저장되어있는 이미지 파일 이름 가져옴
		String 파일이름 = file.getOriginalFilename();
		
		//바탕화면에 pigImg라는 폴더가 없으면 생성하기
		String 이미지저장폴더 = "C:/Users/user1/Desktop/pigImg/";
		
		File 폴더경로확인 = new File(이미지저장폴더);
		//만약에 저장하고자하는 이미지 폴더가 존재하지 않을 경우 경로들 모두 생성!
		//exist -> File 자료형에서만 생성
		if (!폴더경로확인.exists()) {
			폴더경로확인.mkdirs();
			       //mkdirs : mkdir = 폴더 한 개
			       //         mkdirs = 폴더 여러 개
			       //         mkdir을 사용해도 되긴 하지만
			       //         혹시 모를 문제가 발생할 수 있으므로 mkdirs 사용
		}
		
		//폴더가 안전하게 생성되었는지 확인을 모두 마치고 지정된 폴더에 사진 올리기
		File 사진파일올리기 = new File(이미지저장폴더 + 파일이름);
		String DB에파일경로및파일명전달 = 이미지저장폴더 + 파일이름;
		try {
			file.transferTo(사진파일올리기);
			
			//모든 준비가 끝났으니 이미지 정보를 DB에 전달해주기
			Pig pig = new Pig();
			pig.setPig_name(pig_name);
			pig.setPig_age(pig_age);
			pig.setPig_image_path(DB에파일경로및파일명전달);
			                    //DB에파일경로및파일명전달 : Pig_image_path가 String 값이기 때문에
			                    //                    사진파일올리기(File 자료형)이 올 수 없음
			
			pigMapper.uploadPig(pig);
			System.out.println("Mapper에 Service로 pig insert 전달 성공");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
