package com.wallet.document.controller;

import com.wallet.document.model.InsuranceDetails;
import com.wallet.document.service.InsuranceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/insurance")
public class InsuranceDetailsController {

    @Autowired
    private InsuranceDetailsService insuranceDetailsService;

    @GetMapping
    public ResponseEntity<List<InsuranceDetails>> getAllInsuranceDetails() {
        List<InsuranceDetails> insuranceDetailsList = insuranceDetailsService.getAllInsuranceDetails();
        return new ResponseEntity<>(insuranceDetailsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsuranceDetails> getInsuranceDetailsById(@PathVariable Long id) {
        Optional<InsuranceDetails> insuranceDetails = insuranceDetailsService.getInsuranceDetailsById(id);
        return insuranceDetails.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<InsuranceDetails> createInsuranceDetails(@RequestBody InsuranceDetails insuranceDetails) {
        InsuranceDetails savedInsuranceDetails = insuranceDetailsService.saveInsuranceDetails(insuranceDetails);
        return new ResponseEntity<>(savedInsuranceDetails, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsuranceDetails(@PathVariable Long id) {
        insuranceDetailsService.deleteInsuranceDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
