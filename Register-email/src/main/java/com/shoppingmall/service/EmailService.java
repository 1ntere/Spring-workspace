package com.shoppingmall.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
//@RequiredArgsConstructor : @Autowired와 기능이 비슷함
//                           @Autowired : Class 내부에서 변수마다 하나씩 설정해주어야 함
//                           @RequiredArgsConstructor : Class 외부에서 설정해주는 @Autowired 라고 생각
public class EmailService {
	private final JavaMailSender javaMailSender;
	            //JavaMailSender : 자바 자체에서 제공하는 이메일 보내기 기능 틀
	            //                 틀만 제공하는 이유 : 이메일을 전송하는데 어느 회사, 어느 규격의 이메일인지 알 수 없기 때문에
	            //                 이메일을 보낼 때 보내는이, 내용, 받는이 의 틀만 제공
	
	//이메일을 보낼 이메일 주소값	
	private static final String senderEmail = "kwonhc9337javatest@gmail.com";
	      //static : 상시로 사용할 수 있게 고정해 놓음
	                           //"kwonhc9337javatest@gmail.com" : 이메일을 보낼 담당자 이메일 작성
	                           //	보통 application.properties에서 가져온 이메일을 그대로 사용
	private static int number;
	          //number : 인증번호를 보낼 숫자 공간
	
	//랜덤으로 인증번호 생성하는 메서드(기능 = 동작) 설정
	public static void 번호생성() {
		number = (int)(Math.random() * (90000)) + 100000;
		       //(int)(Math.random() * (90000)) + 100000 : 100000 ~ 189999 사이의 임의의 숫자 6자리 숫자 생성
		       //                                          만약에 5자리 임의의 숫자를 생성하고 싶다면
		       //                                          (int)(Math.random() * (9000)) + 10000;
			   //Math.random() : 0.0 ~ 1.0 사이의 임의의 소수(실수) 생성
		       //                ex. 0.0부터 0.99999... 사이의 값
		             //Math.random() * (90000) : 0.0부터 89999.99999... 사이의 값을 반환
		                                      //+ 100000 : 정수의 경우에는 맨 앞자리가 0이 아닌 수가 나오기 전까지
		                                      //           0이 나오면 0을 없애고 표시한다. 
		                                      //           ex. 001 -> 1 처럼 표기 된다.
		                                      //           ex. 01055556666 -> 1055556666
	}
	
	//메일 양식 기능
	public MimeMessage createMail(String mail) { 
		//인증번호 생성
		번호생성();
		//생성된 인증번호를 담는 변수
		MimeMessage 메세지 = javaMailSender.createMimeMessage();
	  //MimeMessage : 자바에서 제공하는 기능으로 이메일 본문 담당
	  //              첨부파일 헤더 같이 보낼 수 있음
		          //메세지 : 메세지 보낼 공간 생성
		try {
			메세지.setFrom(senderEmail);
			   //setFrom : 이메일을 전송하는 주최자의 이메일 주소
			메세지.setRecipients(MimeMessage.RecipientType.TO, mail);
			//태그로 img src를 통해 이미지 같이 보낼 수 있음
			//첨부파일 참조하는 태그를 이용해서 같이 보낼 수 있음
			   //setRecipients : String 타입
			//메세지.setRecipient(MimeMessage.RecipientType.TO, mail);
			     //setRecipient : address 타입
			메세지.setSubject("이메일 인증");
			   //setSubject : 전송하는 이메일의 제목
			String 이메일본문 = "";
			이메일본문 += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
			이메일본문 += "<h1>" + number + "</h1>";
			메세지.setText(이메일본문, "utf-8", "html");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return 메세지;
		     //메세지 : 메세지. 으로 작성한 모든 내용을 담아서 전달하기
	}
	
	public int sendMail(String mail) {
		MimeMessage 메세지 = createMail(mail);
		javaMailSender.send(메세지);
		return number;
	}

}
