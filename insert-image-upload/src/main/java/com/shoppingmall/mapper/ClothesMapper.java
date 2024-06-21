package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shoppingmall.dto.Cloth;

@Mapper
public interface ClothesMapper {
	List<Cloth> getAllClothes();
	
	Cloth getClothById(int clothes_id);
	
	public void uploadCloth(Cloth cloth);
}
