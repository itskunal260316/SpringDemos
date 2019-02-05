package com.lti.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value="singleton")//only one obj will be created by Spring

@Component("cc")//replace <bean> in the xml file.
//name will be refered in many files adnt hus choose the appropriate name
// we use annotation so that we dont have to use the xml file every now and then
public class Calculator implements Calc{
	
		
				
		public int add(int x, int y) {
			return x+y;
		 
		}
}
