package com.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmall.dto.Snacks;
import com.shoppingmall.mapper.SnacksMapper;
/*
Service

@Service 어노테이션을 통해 DB에서 가져온 SQL 구문이나
HTML에서 DB에 넣어줄 값에 추가적인 기능을 작성해주기
*/
@Service
public class SnacksService {
	@Autowired
	//@Autowired : Mapper에 작성한 리스트를 모두 활용하겠다는 어노테이션
	//             객체 안에 한 줄씩 참조할 때 작성
	private SnacksMapper snacksMapper;
	
	//Snack sql에서 가져온 스낵들을 컨트롤러에 전달해주는 메서드(기능)작성
	public List<Snacks> getAllSnacks() {
		//상품목록을 보여줄 때 추가적으로 설정해서 넣어주고 싶은 기능을 나중에 추가적으로 작성
		//예시) 상품 이미지 있는지 확인하고, 이미지가 없으면 엑스박스로 표시
		//이외에도 여러가지 기능들을 작성
		return snacksMapper.getAllSnacks();
	}
}
