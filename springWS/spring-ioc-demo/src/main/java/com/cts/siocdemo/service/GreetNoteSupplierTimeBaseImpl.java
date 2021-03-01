package com.cts.siocdemo.service;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("gntbs")
@Primary
public class GreetNoteSupplierTimeBaseImpl implements GreetNoteSupplier {

	@Override
	public String getGreetNote() {
		String greetNote="";
		
		int h = LocalDateTime.now().getHour();
		
		if(h>=4 && h<=11)
			greetNote="Good Morning";
		else if(h>=11 && h<=16)
			greetNote="Good None";
		else 
			greetNote="Good Evening";
		
		return greetNote;
	}

}
