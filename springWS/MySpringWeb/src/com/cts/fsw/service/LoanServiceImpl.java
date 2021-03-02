package com.cts.fsw.service;

import org.springframework.stereotype.Service;

import com.cts.fsw.model.Loan;

@Service
public class LoanServiceImpl implements LoanService {

	@Override
	public void computeInterest(Loan loan) {
		if(loan!=null) {
			loan.setInterest((loan.getPrincipal()*loan.getRate()*loan.getTime())/100.0);
		}
	}

}
