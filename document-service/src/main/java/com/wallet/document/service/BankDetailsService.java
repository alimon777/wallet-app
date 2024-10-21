package com.wallet.document.service;

import com.wallet.document.model.BankDetails;
import com.wallet.document.repository.BankDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankDetailsService {

    @Autowired
    private BankDetailsRepository bankDetailsRepository;

    public List<BankDetails> getAllBankDetails() {
        return bankDetailsRepository.findAll();
    }

    public Optional<BankDetails> getBankDetailsById(Long id) {
        return bankDetailsRepository.findById(id);
    }

    public BankDetails saveBankDetails(BankDetails bankDetails) {
        return bankDetailsRepository.save(bankDetails);
    }

    public void deleteBankDetails(Long id) {
        bankDetailsRepository.deleteById(id);
    }
}
