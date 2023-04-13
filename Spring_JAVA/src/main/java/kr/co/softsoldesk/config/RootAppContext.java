package kr.co.softsoldesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

import kr.co.softsoldesk.beans.DataBean;
import kr.co.softsoldesk.beans.DataBean2;

//프로젝트 bean
@Configuration
@ComponentScan
public class RootAppContext {


	//DataBean1 타입 주입 @ApplicationScope
	@Bean
	@ApplicationScope
	public DataBean databean1() {
		return new DataBean();
	}
	
	//DataBean2 이름으로 선언(applicationBean2)
	@Bean("applicationBean2")
	@ApplicationScope
	public DataBean2 databean2() {
		return new DataBean2();
	}
	
	
}
