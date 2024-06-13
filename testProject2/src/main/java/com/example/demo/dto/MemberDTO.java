package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
//필드
	private String memberName;
	private String memberPhone;
	private int memberAge;
}
