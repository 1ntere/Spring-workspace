package com.shoppingmall.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
	private int company_id;
	private String company_name;
	private String company_address;
	private String company_phone;
	      //String : 핸드폰번호는 맨 앞이 0으로 시작하기 때문에 String으로 작성해줌
          //         int는 맨 앞에 붙은 0을 자동으로 없애주기 때문
	      //         예를 들어 01011112222를 작성했을 때, String의 경우 01011112222로 저장되지만
	      //         int의 경우 1011112222가 저장된다.
}