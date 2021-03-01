package com.cts.siocdemo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("ags")
@Scope("prototype")
public class AdvancedGreetServiceImpl implements GreetService {
	@Value("${greet.note}")
	private String greetNote;
	
	public String greetUser(String userName) {
		return greetNote +" "+userName;
	}
	
	
}
