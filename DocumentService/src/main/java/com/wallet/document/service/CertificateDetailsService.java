package com.wallet.document.service;

import com.wallet.document.model.CertificateDetails;
import com.wallet.document.repository.CertificateDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateDetailsService {

    @Autowired
    private CertificateDetailsRepository certificateDetailsRepository;

    public List<CertificateDetails> getAllCertificateDetails() {
        return certificateDetailsRepository.findAll();
    }

    public Optional<CertificateDetails> getCertificateDetailsById(Long id) {
        return certificateDetailsRepository.findById(id);
    }

    public CertificateDetails saveCertificateDetails(CertificateDetails certificateDetails) {
        return certificateDetailsRepository.save(certificateDetails);
    }

    public void deleteCertificateDetails(Long id) {
        certificateDetailsRepository.deleteById(id);
    }
}
