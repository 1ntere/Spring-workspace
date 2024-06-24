package com.shoppingmall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.shoppingmall.dto.Member;

@Mapper
public interface MemberMapper {
			        
	Member getLogin(@Param("member_name") String member_name,
	              //@Param : 앞에서 매개변수인 파라미터를 이용해서 일치하는 값을 가져온다는 뜻
			        @Param("member_phone") String member_phone);
}
