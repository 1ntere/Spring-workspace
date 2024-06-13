package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.MemberDTO;
import com.example.demo.dto.StudentDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller //요청하거나 응답제어 역할을 명시, Bean 등록
                                    //Bean : Spring에서 어떤 기능을 하라 설정해 놓은 값
@RequestMapping("example") // /example로 시작하는 주소를 해당 컨트롤러에 넣어줌
@Slf4j //lombok 라이브러리가 제공하는 로그 객체 자동생성 어노테이션
public class ExampleController {
	/*
	Model
	Spring에서 데이터 전달 역할을 하는 객체
	org.springframework.ui 패키지 //import org.springframework.ui.Model;
	@SessionAttributes와 함께 사용할 경우 session scope 반환
	
	기본 사용법
	Model.addAttribute("     key      ",    value  );
	Model.addAttribute("html에전달가능한이름", 전달할값을작성);
	*/
	@GetMapping("ex1") // /example/ex1 주소로 보여지는 값
	public String ex1(HttpServletRequest req, Model model) {
		
		req.setAttribute("test1", "HttpServletRequest로 전달한 값");
		model.addAttribute("test2", "Model로 전달한 값");
		
		//단일 값(숫자, 문자열) Model을 이용해서 html 전달
		model.addAttribute("productName", "종이컵");
		                  //productName : ex1.html의 35, 36번째 줄
		                  //		        productName : <th:block th:text="${productName}">상품명</th:block>
		                  //              				/ <span th:text="${productName}">상품명</span>
		                  //              ${productName}인 곳의 상품명 대신에 종이컵이 들어감
		
		//price로 2000원을 전달
		model.addAttribute("price", 2000);
		                  //price : ex1.html의 42~45번째 줄 
		                  //		price : 
		                  //        <span class="price">
		                  //        	<th:block th:text="${price}">가격</th:block>   원
	                      //        </span>
		                  //        ${price}인 곳의 가격 대신에 2000이 들어감 
		
		model.addAttribute("productCompany", "COMPANY");
		
		//복수 값(배열, List) Model을 이용해서 html 전달
		//1. fruitList
		List<String> fruitList = new ArrayList<>();//1. String 자료형의 List 생성
		fruitList.add("사과");//2. List에 값을 넣기
		fruitList.add("딸기");
		fruitList.add("바나나");
		
		model.addAttribute("fruitList", fruitList);//3. ${fruitList}인 곳에 생성한 리스트를 전달
		
		//2. animal
		List<String> animal = new ArrayList<>();
		animal.add("호랑이");
		animal.add("토끼");
		animal.add("거북이");
		
		model.addAttribute("animal", animal);
		
		//DTO 객체 Model을 이용해서 HTML 전달
		//1. Student
		StudentDTO std = new StudentDTO();//1. StudentDTO를 불러올 객체 생성
		std.setStudentNo("12345");//2. 불러온 객체에 setter를 통해 값을 설정
		std.setName("홍길동");
		std.setAge(30);
		
		model.addAttribute("std", std);//3. ${std}, ${std.studentNo}, ${std.name}, ${std.age}인 곳에 값을 전달
		                //("std", std) : ("별칭" , 별칭과 같지 않아도 됨)
		                //               하지만 이름이 다르면 문제가 생겼을 때 찾기 어렵기 때문에
		                //               별칭과 동일하게 설정해주는 것이 좋음
        /*
        model.addAttribute("a", b);
        <li th:text="${a}">수정될 값<li>
        
        	a와 b의 별칭을 동일하게 설정해주는 것이 좋음
        */
		
		List<StudentDTO> stdList = new ArrayList<>();
		stdList.add(new StudentDTO("111", "김일번", 10));
		stdList.add(new StudentDTO("222", "김이번", 20));
		stdList.add(new StudentDTO("333", "김삼번", 30));
		model.addAttribute("stdList", stdList);
		
		//2. Member
		MemberDTO mem = new MemberDTO();
		mem.setMemberNo("1");
		mem.setMemberName("김철수");
		mem.setMemberAge(20);
		
		model.addAttribute("mem", mem);
		
		List<MemberDTO> memList = new ArrayList<>();
		memList.add(new MemberDTO("1", "김하나", 21));
		memList.add(new MemberDTO("2", "김두리", 22));
		memList.add(new MemberDTO("3", "김세찌", 23));
		model.addAttribute("memList", memList);
		
		return "example/ex1"; //templates/example/ex1.html 파일을 바라보는 것
	}
	
	/*
	@PathVariable
		주소 중 일부분을 변수 값처럼 사용
		해당 어노테이션으로 얻어온 값은 request scope에 세팅
	*/
	@GetMapping("/ex2/{number}")
	public String pathVariableTest(@PathVariable("number") int number) {
		                                        //number : 주소 중 {number} 부분의 값을 가져와
		                                        //         매개변수에 저장
		                                        //requestScope 세팅
		return "example/testResult";
	}
	
	@PostMapping("ex2")
	public String ex2(Model model) {
		model.addAttribute("str", "<h1> 테스트중 &times; </h1>");
		return "example/ex2";
	}
	
	@GetMapping("ex3")
	public String ex3(Model model) {
		model.addAttribute("boardNo", 10);
		model.addAttribute("key", "제목");
		model.addAttribute("query", "검색어");
		
		return "example/ex3";
	}
}
