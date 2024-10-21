package com.wallet.document.controller;

import com.wallet.document.model.BankDetails;
import com.wallet.document.service.BankDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bank")
public class BankDetailsController {

    @Autowired
    private BankDetailsService bankDetailsService;

    @GetMapping
    public ResponseEntity<List<BankDetails>> getAllBankDetails() {
        List<BankDetails> bankDetailsList = bankDetailsService.getAllBankDetails();
        return new ResponseEntity<>(bankDetailsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankDetails> getBankDetailsById(@PathVariable Long id) {
        Optional<BankDetails> bankDetails = bankDetailsService.getBankDetailsById(id);
        return bankDetails.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<BankDetails> createBankDetails(@RequestBody BankDetails bankDetails) {
        BankDetails savedBankDetails = bankDetailsService.saveBankDetails(bankDetails);
        return new ResponseEntity<>(savedBankDetails, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankDetails(@PathVariable Long id) {
        bankDetailsService.deleteBankDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
