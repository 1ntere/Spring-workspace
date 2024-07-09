package com.kh.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.test.dto.GoodsItem;

/*
MapperScan은 여기(Mapper)에서 사용하는 것이 아니라
com.kh.test 안에 있는 @SpringBootApplication의 위 아래 상관없이
@MapperScan(매퍼가들어있는패키지명) 어노테이션 넣어줌
@MapperScan(com.kh.test.mapper)
*/
@Mapper
public interface GoodsItemMapper {
	//Integer existsByName(String itemName); -> resultMap을 사용하지 않을 때 사용
	GoodsItem existsByName(@Param("itemName") String itemName); // resultMap을 사용해서 COUNT(*) 값을 넘길 때 사용
}
