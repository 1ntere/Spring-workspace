package com.shoppingmall.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shoppingmall.dto.Cloth;
import com.shoppingmall.mapper.ClothesMapper;

@Service
public class ClothesService {
	@Autowired
	private ClothesMapper clothesMapper;
	
	public List<Cloth> getAllClothes() {
		return clothesMapper.getAllClothes();
	}
	
	public Cloth getClothById(int clothes_id) {
		return clothesMapper.getClothById(clothes_id);
	}
	
	public void uploadCloth(String clothes_name,
			int clothes_price, 
			String clothes_category, 
			MultipartFile file) {
		String fileName = file.getOriginalFilename();
		System.out.println("file Name : " + fileName);
		
		String uploadDir = "C:/Users/user1/servlet_jsp_workspace/insert-image-upload/src/main/resources/static/images/";
		File imgFile = new File(uploadDir + fileName);
		if (!imgFile.exists()) {
			imgFile.mkdirs();
		}
		
		try {
			file.transferTo(imgFile);
			
			Cloth cloth = new Cloth();
			cloth.setClothes_name(clothes_name);
			cloth.setClothes_price(clothes_price);
			cloth.setClothes_category(clothes_category);
			cloth.setClothes_image_path("/images/"+clothes_category+"/"+fileName);
			clothesMapper.uploadCloth(cloth);
			System.out.println("파일 업로드 Service를 성공적으로 완료했습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
