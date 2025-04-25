package myspring.di.annot.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.annot.HelloBean;
import myspring.di.annot.PrinterBean;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:hello-di.xml")
public class HelloBeanSpringTest {
	@Autowired
	HelloBean hello;
	
	@Resource(name = "stringPrinter")
	PrinterBean printer;	
	
	@Test
	void helloBean() {
		assertEquals("Hello 어노테이션", hello.sayHello());
		hello.print();
		assertEquals("Hello 어노테이션", printer.toString());
		
		for(String name: hello.getNames()) {
			System.out.println(name);
		}
	}
}