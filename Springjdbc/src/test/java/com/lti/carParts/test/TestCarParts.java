package com.lti.carParts.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.CarPart;
import com.lti.entity.CarPartsDao;

public class TestCarParts {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("carparts-config.xml");
		
		CarPartsDao dao = (CarPartsDao)context.getBean("carPartsDao1");// this is only a ref of the interface
		CarPart part = new CarPart();
		part.setPartNo(1);
		part.setName("Nut and Bolts");
		part.setCarModel("VW Polo");
		part.setPrice(500);
		part.setQuantity(30);
		dao.addNewPart(part);
		
	}

	
}
