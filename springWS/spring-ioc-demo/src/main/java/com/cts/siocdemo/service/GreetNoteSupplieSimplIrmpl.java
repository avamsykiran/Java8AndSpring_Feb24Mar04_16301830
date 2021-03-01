package com.cts.siocdemo.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("gnss")
public class GreetNoteSupplieSimplIrmpl implements GreetNoteSupplier {

	@Override
	public String getGreetNote() {		
		return "Vankkam";
	}

}
