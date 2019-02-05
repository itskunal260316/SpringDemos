package quickstart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.component.Calc;
import com.lti.component.Calculator;
import com.lti.component.HelloWorld;
import com.lti.component.TextEditor;

public class TestCode {

	public static void main(String[] args) {
		// loading the IoC container  or core container
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

		// Accessing one of the bean
		HelloWorld hw = (HelloWorld) context.getBean("bean1"); // <bean id="bean1"
		System.out.println(hw.sayHello("Mrunal"));

		for (int i = 0; i < 4; i++) {
			HelloWorld hw1 = (HelloWorld) context.getBean("bean2"); // <bean id="bean1"
			System.out.println(hw1.sayHello("Kunal"));
		}

		// by using the annotaion of the component
		Calc cal = (Calc) context.getBean("cc"); // here we are typecasting getBean() with the interface
		// interface Calc -> Class Calculator
		System.out.println(cal.add(10, 20));

		TextEditor te = (TextEditor) context.getBean("te");
		te.loadTextDocument("  abc.txt");

	}
}
