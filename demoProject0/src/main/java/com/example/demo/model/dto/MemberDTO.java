package com.example.demo.model.dto;

/*
앞으로 Getter와 Setter는 Lombok 라이브러리를 활용해서 길게 작성하지 않음

기본 생성자
*/
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class MemberDTO {
	//나중에 DB랑 연결할 모델들 작성
//필드
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
//메서드
	//Getter -> lombok @Getter 자동완성 사용하기
	//Setter -> lombok @Setter 자동완성 사용하기
	//기본생성자 -> lombok @NoArgsConstructor 자동완성 사용하기
	//필수생성자 -> lombok @AllArgsConstructor 자동완성 사용하기
	//toString ->  lombok @ToString 자동완성 사용하기
}
