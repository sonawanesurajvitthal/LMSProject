package com.lms.controller;

import com.lms.entity.Loan;
import com.lms.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Loan> getLoan(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getLoanById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLoan(@PathVariable int id){
        loanService.deleteLoanById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
    }

    @PostMapping("/save")
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.saveLoan(loan));
    }

    @PutMapping("/update")
    public ResponseEntity<Loan> updateLoan(@RequestBody Loan loan){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.updateLoan(loan));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Loan>> getLoan(){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.listOfLoan());
    }
}
