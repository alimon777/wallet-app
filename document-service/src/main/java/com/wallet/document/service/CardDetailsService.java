package com.wallet.document.service;

import com.wallet.document.model.CardDetails;
import com.wallet.document.repository.CardDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardDetailsService {

    @Autowired
    private CardDetailsRepository cardDetailsRepository;

    public List<CardDetails> getAllCardDetails() {
        return cardDetailsRepository.findAll();
    }

    public Optional<CardDetails> getCardDetailsById(Long id) {
        return cardDetailsRepository.findById(id);
    }

    public CardDetails saveCardDetails(CardDetails cardDetails) {
        return cardDetailsRepository.save(cardDetails);
    }

    public void deleteCardDetails(Long id) {
        cardDetailsRepository.deleteById(id);
    }
}
