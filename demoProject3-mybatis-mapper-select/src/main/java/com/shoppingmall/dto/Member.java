package com.shoppingmall.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private int member_id;
	private String username;
	private String password;
	private String email;
	private String created_at;
}