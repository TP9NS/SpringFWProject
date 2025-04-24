package myspring.di.xml;

import java.util.List;

public class Hello {
	String name;
	Printer printer;
	List<String> names;

	public Hello() {
		System.out.println(this.getClass().getName()+"기본 생성자 호출 됨");
	}

	public Hello(String name, Printer printer) {
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
		System.out.println("setnames 호출 됐어~!");
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("setname 호출 됐어!~ "+name);
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
		System.out.println("setprinter 호출 됐어~!"+printer.getClass().getName());
	}

	public String sayHello() {
		return "Hello " + name;
		
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
