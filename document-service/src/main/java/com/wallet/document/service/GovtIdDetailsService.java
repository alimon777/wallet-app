package com.wallet.document.service;

import com.wallet.document.model.GovtIdDetails;
import com.wallet.document.repository.GovtIdDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GovtIdDetailsService {

    @Autowired
    private GovtIdDetailsRepository govtIdDetailsRepository;

    public List<GovtIdDetails> getAllGovtIds() {
        return govtIdDetailsRepository.findAll();
    }

    public Optional<GovtIdDetails> getGovtIdById(Long id) {
        return govtIdDetailsRepository.findById(id);
    }

    public GovtIdDetails saveGovtId(GovtIdDetails govtIdDetails) {
        return govtIdDetailsRepository.save(govtIdDetails);
    }

    public void deleteGovtId(Long id) {
        govtIdDetailsRepository.deleteById(id);
    }
}
