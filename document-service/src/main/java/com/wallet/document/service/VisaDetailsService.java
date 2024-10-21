package com.wallet.document.service;

import com.wallet.document.model.VisaDetails;
import com.wallet.document.repository.VisaDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisaDetailsService {

    @Autowired
    private VisaDetailsRepository visaDetailsRepository;

    public List<VisaDetails> getAllVisaDetails() {
        return visaDetailsRepository.findAll();
    }

    public Optional<VisaDetails> getVisaDetailsById(Long id) {
        return visaDetailsRepository.findById(id);
    }

    public VisaDetails saveVisaDetails(VisaDetails visaDetails) {
        return visaDetailsRepository.save(visaDetails);
    }

    public void deleteVisaDetails(Long id) {
        visaDetailsRepository.deleteById(id);
    }
}
