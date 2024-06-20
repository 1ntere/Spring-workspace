package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shoppingmall.dto.Pig;

@Mapper
public interface PigMapper {
	//전체 가져오기 -> List
	List<Pig> getAllPigs();
	
	//돼지 정보 하나만 가져오기
	Pig getPigById(int pig_id);
}