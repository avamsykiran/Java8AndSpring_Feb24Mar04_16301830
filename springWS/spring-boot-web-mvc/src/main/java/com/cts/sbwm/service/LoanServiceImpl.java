package com.cts.sbwm.service;

import org.springframework.stereotype.Service;

import com.cts.sbwm.model.Loan;

@Service
public class LoanServiceImpl implements LoanService {

	@Override
	public void computeInterest(Loan loan) {
		if(loan!=null) {
			loan.setInterest((loan.getPrincipal()*loan.getRate()*loan.getTime())/100.0);
		}
	}

}
