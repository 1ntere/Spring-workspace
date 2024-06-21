package com.shoppingmall.service;

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
	
	public void uploadCloth(String clothes_id,
			int clothes_price, 
			String clothes_category, 
			MultipartFile file) {
		String fileName = file.getOriginalFilename();
		System.out.println("file Name : " + fileName);
		
		String uploadDir = "C:/Users/user1/servlet_jsp_workspace/insert-image-upload/src/main/resources/static/images/";
	}
	
}
