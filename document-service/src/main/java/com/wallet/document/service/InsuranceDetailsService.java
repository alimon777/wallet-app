package com.wallet.document.service;

import com.wallet.document.model.InsuranceDetails;
import com.wallet.document.repository.InsuranceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceDetailsService {

    @Autowired
    private InsuranceDetailsRepository insuranceDetailsRepository;

    public List<InsuranceDetails> getAllInsuranceDetails() {
        return insuranceDetailsRepository.findAll();
    }

    public Optional<InsuranceDetails> getInsuranceDetailsById(Long id) {
        return insuranceDetailsRepository.findById(id);
    }

    public InsuranceDetails saveInsuranceDetails(InsuranceDetails insuranceDetails) {
        return insuranceDetailsRepository.save(insuranceDetails);
    }

    public void deleteInsuranceDetails(Long id) {
        insuranceDetailsRepository.deleteById(id);
    }
}
