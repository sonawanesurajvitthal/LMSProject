package com.lms.service;

import com.lms.entity.Loan;

import java.util.List;

public interface LoanService {

    public Loan getLoanById(int id);

    public Loan saveLoan(Loan loan);

    public List<Loan> listOfLoan();

    public void deleteLoanById(int id);

    public Loan updateLoan(Loan loan);
}
