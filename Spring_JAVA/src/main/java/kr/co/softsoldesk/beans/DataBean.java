package kr.co.softsoldesk.beans;


import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataBean {
	@Size(min=2, max=10)
	private String data1;
	
	@Max(100)
	private int data2;
		
}