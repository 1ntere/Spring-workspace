package com.shoppingmall.controller;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shoppingmall.util.FileUploadUtil;

//★ api : Mapping () 괄호 안에 /로 된 것의 갯수
//        get 1개(@GetMapping("/upload")), post 1개(@PostMapping("/upload"))
//@RequestMapping("api/v1/img")
              //"api/v1/img" : api
//ImageUploadController 밑에 작성하는 모든 주소 앞에 api/v1/img가 붙음
@RequestMapping("api/v2/img")
@RestController
//@RestController : 백엔드용으로 작성하는 controller
/*
[개발 흐름의 순서]
기획 -> 백엔드 -> 프론트엔드
SQL -> 백엔드 -> CSS

@Controller		 : 주로 HTML(view 화면)을 반환하기 위해 사용
@RestController	 : @Controller와 @ResponseBody가 합쳐진 형태
                   json 형태의 객체 데이터를 반환
                   백엔드 개발자가 보이는 화면(view, html)이 없을 때
                   데이터가 무사히 들어오고 나오는지 확인하기 위해 사용하는 컨트롤러
                   React에 프론트엔드를 작성할 때 사용하기도 함
*/
public class ImageUploadController {
	//Method 'GET' is not supported.
	@GetMapping("/upload")
	          //"/upload" : ★ get api 1개 생성 = api/v2/img/upload
	public String get() {
		return "html 파일 위치를 가리키거나 가리킬 주소";
	}
	
	@PostMapping("/upload")
	            ///upload : api/v1/img/upload
	public void savImage(@RequestParam("files")MultipartFile[] files) {
		String 업로드할폴더위치 = "imgFolder";
		                   //"imgFolder" : static 밑에 imgFolder를 만들어서 업로드할 예정
		//배열로 이미지를 담아서 한번에 전송
		Arrays.asList(files).stream().forEach(file->{
			
			//파일 이름을 깔끔하게 정리
			String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
			                //StringUtils : import org.springframework.util.StringUtils;
			                            //cleanPath : 파일 이름에 포함될 수 있는 잠재적인 악의적인 값(악성코드 등)을 제거
			                //file.getOriginalFilename() : file에서 가져오기(=get) 원본(=original) 파일이름(=FileName())
			System.out.println(fileName);
			
			try {
				//파일올리기 -> 업로드할 파일 위치에 내가 원하는 파일 이름으로 파일을 올리겠다.
				FileUploadUtil.saveFile(업로드할폴더위치, fileName, file);
				
				
			} catch(Exception e) {
				
			}
		});
	}
}
