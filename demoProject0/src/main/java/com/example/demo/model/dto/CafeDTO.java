package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//한번에 import 하는 단축키 : ctrl + shift + o
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CafeDTO {
	private String cafeCommentName;
	private String cafeCommentOpinion;
}
