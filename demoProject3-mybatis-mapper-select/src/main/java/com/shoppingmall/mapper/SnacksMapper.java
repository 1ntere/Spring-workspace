package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shoppingmall.dto.Snacks;
/*
Mapper

Spring 자체에서 이 Mapper 인터페이스는
SQL DB에 작성한 코드를 바라보는 위치라는 @Mapper 어노테이션을 작성
*/
@Mapper
public interface SnacksMapper {
	//DB에서 모든 과자들을 가져올 수 있도록 진열목록을 작성
	List<Snacks> getAllSnacks();
}
