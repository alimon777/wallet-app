package com.wallet.document.controller;

import com.wallet.document.model.VisaDetails;
import com.wallet.document.service.VisaDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/visa")
public class VisaDetailsController {

    @Autowired
    private VisaDetailsService visaDetailsService;

    @GetMapping
    public ResponseEntity<List<VisaDetails>> getAllVisaDetails() {
        List<VisaDetails> visaDetailsList = visaDetailsService.getAllVisaDetails();
        return new ResponseEntity<>(visaDetailsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisaDetails> getVisaDetailsById(@PathVariable Long id) {
        Optional<VisaDetails> visaDetails = visaDetailsService.getVisaDetailsById(id);
        return visaDetails.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<VisaDetails> createVisaDetails(@RequestBody VisaDetails visaDetails) {
        VisaDetails savedVisaDetails = visaDetailsService.saveVisaDetails(visaDetails);
        return new ResponseEntity<>(savedVisaDetails, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisaDetails(@PathVariable Long id) {
        visaDetailsService.deleteVisaDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
