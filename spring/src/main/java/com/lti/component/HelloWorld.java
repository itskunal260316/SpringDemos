package com.lti.component;


//here we used the bean tag in the xml file
public class HelloWorld {
	
	public HelloWorld() {
		// TODO Auto-generated constructor stub
	 System.out.println("constructor called");
	}

	public String sayHello(String name) {
		return "Hello" + name;
	}

}
