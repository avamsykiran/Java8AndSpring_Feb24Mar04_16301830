package com.cts.siocdemo.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("gs")
@Service("gs")
public class GreetServiceImpl implements GreetService {
	public String greetUser(String userName) {
		return "Hello " +userName;
	}
}
