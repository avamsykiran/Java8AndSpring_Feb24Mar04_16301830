package com.cts.siocdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("egs")
public class EnhacnedGreetServiceImpl implements GreetService {

	@Autowired
	//@Qualifier("gnss")
	private GreetNoteSupplier gns;
		
	@Override
	public String greetUser(String userName) {
		return gns.getGreetNote() + " " + userName;
	}

}
