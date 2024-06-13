package com.example.demo.dto;

import lombok.*;
/*
Spring 같은 경우 getter가 필수로 있어야 함
	${StudentDTO.getName()} == ${StudentDTO.name}
	
	getter 대신 필드명 호출하는 형식 작성
	가능한 이유 : getter를 자동으로 호출한다 생각하기 때문
*/
@Getter
@Setter
@ToString//tostring() 메서드 자동으로 override되어서 추가
@NoArgsConstructor//기본생성자(매개변수가 없는 생성자)
@AllArgsConstructor//필수생성자(필드의 모든 매개변수를 가지고 있는 생성자)
public class StudentDTO {
//필드
	private String studentNo;//학번
	              //studentNo : ex1.html에서 125번째 줄에 작성한
                  //            <li th:text="${std.studentNo}">학번</li>
	              //            에서 ${std.studentNo}인 학번과 관련된 매개변수 생성
	private String name;//이름
	private int age;//나이
}
