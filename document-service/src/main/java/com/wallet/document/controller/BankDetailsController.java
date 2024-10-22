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

    // Get all bank details
    @GetMapping
    public ResponseEntity<List<BankDetails>> getAllBankDetails() {
        List<BankDetails> bankDetailsList = bankDetailsService.getAllBankDetails();
        return new ResponseEntity<>(bankDetailsList, HttpStatus.OK);
    }

    // Get bank details by ID
    @GetMapping("/{id}")
    public ResponseEntity<BankDetails> getBankDetailsById(@PathVariable Long id) {
        Optional<BankDetails> bankDetails = bankDetailsService.getBankDetailsById(id);
        return bankDetails.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get bank details by familyId
    @GetMapping("/family/{familyId}")
    public ResponseEntity<List<BankDetails>> getBankDetailsByFamilyId(@PathVariable int familyId) {
        List<BankDetails> bankDetailsList = bankDetailsService.getBankDetailsByFamilyId(familyId);
        if (bankDetailsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bankDetailsList, HttpStatus.OK);
    }

    // Create new bank details
    @PostMapping
    public ResponseEntity<BankDetails> createBankDetails(@RequestBody BankDetails bankDetails) {
        BankDetails savedBankDetails = bankDetailsService.saveBankDetails(bankDetails);
        return new ResponseEntity<>(savedBankDetails, HttpStatus.CREATED);
    }

    // Update existing bank details
    @PutMapping("/{id}")
    public ResponseEntity<BankDetails> updateBankDetails(@PathVariable Long id, @RequestBody BankDetails bankDetails) {
        Optional<BankDetails> existingBankDetails = bankDetailsService.getBankDetailsById(id);
        if (existingBankDetails.isPresent()) {
            bankDetails.setId(id); // Ensures that the record is updated
            BankDetails updatedBankDetails = bankDetailsService.saveBankDetails(bankDetails);
            return new ResponseEntity<>(updatedBankDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete bank details by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankDetails(@PathVariable Long id) {
        bankDetailsService.deleteBankDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
