package com.shoppingmall.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImageUploadMapper {
	//void insertImageUpload(ImageUpload imageUpload);
	void insertImageUpload(Map<String, Object> paramMap);
	/*
	Controller에서 paramMap을 Mapper로 전달할 때
	imageUploadMapper.insertImageUpload(paramMap);
	으로 코드를 작성함
	
	paramMap은 Map<String, Object>이므로
	
	Map과 String, Object를 작성해주었기 때문에
	Mapper에서도 Map<String, Object>를 붙여줌
	*/
}