package myspring.di.xml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
public class HelloJunitTest {
	ApplicationContext context;
	@BeforeEach
	void container() {
		//1. Container Object 생성
		context = new GenericXmlApplicationContext("classpath:hello-di.xml");
		
	}
	
	@Test
	void helloBean() {
		System.out.println("Hello Junit");
		//2. Container 객체가 생선한 spring Bean을 요청하기
		
		Hello helloById =(Hello)context.getBean("hello");
		Hello helloByType = context.getBean("hello",Hello.class);
		
		//bean 주소비교
		
		System.out.println(helloById==helloByType);
		assertSame(helloById, helloByType);
		assertEquals("Hello 스프링",helloById.sayHello());
		helloById.print();
		//Container 객체가 생성한 STringPrinter 스프링빈 요청
		//<property name = "printer" ref "strPrinter" /> 설정 테스트
		Printer printer = context.getBean("strPrinter",StringPrinter.class);
		assertEquals("Hello 스프링",printer.toString());
		
	}
	
}
