package com.cts.siocdemo.ui;

import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.siocdemo.config.BeanConfiguaration;
import com.cts.siocdemo.service.GreetService;

public class GreetApplication {

	public static void main(String[] args) {

		ApplicationContext context =
				new AnnotationConfigApplicationContext(BeanConfiguaration.class);
		
		GreetService gsi = (GreetService) context.getBean("gs");
		System.out.println(gsi.greetUser("Vamsy"));
		
		GreetService agsObj = (GreetService) context.getBean("ags");
		System.out.println(agsObj.greetUser("Vamsy"));
		System.out.println(agsObj.hashCode());
		GreetService agsObjCopy = (GreetService) context.getBean("ags");
		System.out.println(agsObjCopy.hashCode());
		
		
		GreetService egsObj = (GreetService) context.getBean("egs");
		System.out.println(egsObj.greetUser("Vamsy"));
		
		Random r = (Random) context.getBean("random");
		System.out.println(r.nextInt(100));
	}

}
