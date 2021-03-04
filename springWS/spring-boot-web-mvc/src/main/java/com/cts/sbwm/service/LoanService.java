package com.cts.sbwm.service;

import com.cts.sbwm.model.Loan;

public interface LoanService {
	void computeInterest(Loan loan);
}
