package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shoppingmall.dto.SC;

@Mapper
public interface SCMapper {
	//getAllSC로 가져온 SECECT, JOIN문 보여주기
	List<SC> getAllSC();
	
	//위의 코드는 모든 제품을 가져오기 때문에 List로 작성했지만
	//아래의 코드는 하나의 값만 가져오기 때문에 List를 없애준 것
	//snack_id에 해당하는 값을 가져오겠다라는 의미
	SC getSnackById(int snack_id);
	
	SC getCompanyById(int company_id);
}
