package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shoppingmall.dto.Member;

@Mapper
public interface MemberMapper {
	void insertMember(Member member);
	
	List<Member> getAllMember();
}
