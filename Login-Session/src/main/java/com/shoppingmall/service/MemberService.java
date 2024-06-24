package com.shoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmall.dto.Member;
import com.shoppingmall.mapper.MemberMapper;

@Service
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	public Member getLogin(String member_name, String member_phone) {
		return memberMapper.getLogin(member_name, member_phone);
	}
}