package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
	private int MemberId;
	private String memberName;
	private int memberAge;
	private String memberPhone;
}
