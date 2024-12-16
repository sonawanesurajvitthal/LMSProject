package com.lms.service;

import com.lms.entity.Loan;
import com.lms.exception.LoanNotFoundException;
import com.lms.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService{

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public Loan getLoanById(int id) {
        return loanRepository.findById(id)
                .orElseThrow(()-> new LoanNotFoundException("Loan not Exit against id: "+id));
    }

    @Override
    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> listOfLoan() {
        return loanRepository.findAll();
    }

    @Override
    public void deleteLoanById(int id) {
        loanRepository.findById(id)
                .orElseThrow(()-> new LoanNotFoundException("Not Allow to Delete, Because Loan not Exit id: "+id));

        loanRepository.deleteById(id);
    }

    @Override
    public Loan updateLoan(Loan loan) {

        Loan tempLoan = loanRepository.findById(loan.getId())
                .orElseThrow(()-> new LoanNotFoundException("Not Allow to Update, Because Loan not Exit id: "+loan.getId()));

//        if(loan.getAmount() == 0){
//            loan.setAmount(tempLoan.getAmount());
//        }
//        if(loan.getName() == null){
//            loan.setName(tempLoan.getName());
//        }

        return loanRepository.save(loan);
    }
}
