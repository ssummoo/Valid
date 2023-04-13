package kr.co.softsoldesk.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softsoldesk.beans.DataBean;


@Controller
public class TestController {
	
	@GetMapping("/input_data")
	public String input_data() {
		
		return "input_data";
	}
	//@Valid : 유효성 검사
	//BindingResult : 유효성 검사 결과 
	@PostMapping("/input_pro")
	public String input_pro(@Valid DataBean dataBean, BindingResult result) {
		
		System.out.println("data1 : "+dataBean.getData1());
		System.out.println("data2 : "+dataBean.getData2());
		
		System.out.println("BindingResult : "+result);
		if(result.hasErrors()) {
			for(ObjectError obj:result.getAllErrors()) {
				System.out.println("메세지 : "+obj.getDefaultMessage());
				System.out.println("code : "+obj.getCode());
				System.out.println("object name: "+obj.getObjectName());
				System.out.println("==========================================");
				
				String [] codes = obj.getCodes();
				for(String c1 : codes) {
					System.out.println(c1);
				}
				
				if(codes[0].equals("Size.dataBean.data1")) {
					System.out.println("data1은 2 ~ 10글자를 담을 수 있습니다");
				} else if(codes[0].equals("Max.dataBean.data2")){
					System.out.println("data2는 100 이하의 값만 담을 수 있습니다");
				}
				return "input_data";  //유효성 검사 탈락 시 다시 입력
			}
		}
			
			
		return "input_success"; //유효성 검사 성공
	}
	
	
}