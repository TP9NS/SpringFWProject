package myspring.di.xml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
public class HelloJunitTest {
	@Test
	void helloBean() {
		System.out.println("Hello Junit");
		//1. Container Object 생성
		ApplicationContext context = new GenericXmlApplicationContext("classpath:hello-di.xml");
		//2. Container 객체가 생선한 spring Bean을 요청하기
		
		Hello helloById =(Hello)context.getBean("hello");
		Hello helloByType = context.getBean("hello",Hello.class);
		
		//bean 주소비교
		
		System.out.println(helloById==helloByType);
		assertSame(helloById, helloByType);
	}
	
}
