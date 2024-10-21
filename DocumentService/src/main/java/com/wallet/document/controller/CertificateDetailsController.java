package com.wallet.document.controller;

import com.wallet.document.model.CertificateDetails;
import com.wallet.document.service.CertificateDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/certificate")
public class CertificateDetailsController {

    @Autowired
    private CertificateDetailsService certificateDetailsService;

    @GetMapping
    public ResponseEntity<List<CertificateDetails>> getAllCertificateDetails() {
        List<CertificateDetails> certificateDetailsList = certificateDetailsService.getAllCertificateDetails();
        return new ResponseEntity<>(certificateDetailsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CertificateDetails> getCertificateDetailsById(@PathVariable Long id) {
        Optional<CertificateDetails> certificateDetails = certificateDetailsService.getCertificateDetailsById(id);
        return certificateDetails.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CertificateDetails> createCertificateDetails(@RequestBody CertificateDetails certificateDetails) {
        CertificateDetails savedCertificateDetails = certificateDetailsService.saveCertificateDetails(certificateDetails);
        return new ResponseEntity<>(savedCertificateDetails, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertificateDetails(@PathVariable Long id) {
        certificateDetailsService.deleteCertificateDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
