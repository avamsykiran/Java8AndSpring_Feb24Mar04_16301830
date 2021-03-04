package com.cts.sbwm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbwm.model.Loan;
import com.cts.sbwm.service.LoanService;

@Controller
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@GetMapping("/loan")
	public String showLoanPage() {
		return "loanPage";
	}
	
	@PostMapping("/loan")
	public ModelAndView showLaonPageWithInterest(@ModelAttribute Loan loan) {
		
		loanService.computeInterest(loan);

		return new ModelAndView("loanPage","loan",loan);
	}
}
