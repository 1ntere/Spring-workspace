package com.shoppingmall.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SC {
	private int snack_id;
	private String snack_name;
	private int price;
	
	//snackAndCompany.xml에서 작성한 JOIN문에서
	//snacks 테이블에 있는 company_id와 company 테이블에 있는 company_id가 서로 값이 일치할 경우
	//company 테이블에 있는 company_name과 company_phone을 가져오겠다
	private int company_id;
	private String company_name;
	private String company_phone;
	private String company_address;
}
