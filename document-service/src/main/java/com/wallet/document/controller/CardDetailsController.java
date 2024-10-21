package com.wallet.document.controller;

import com.wallet.document.model.CardDetails;
import com.wallet.document.service.CardDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/card")
public class CardDetailsController {

    @Autowired
    private CardDetailsService cardDetailsService;

    @GetMapping
    public ResponseEntity<List<CardDetails>> getAllCardDetails() {
        List<CardDetails> cardDetailsList = cardDetailsService.getAllCardDetails();
        return new ResponseEntity<>(cardDetailsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDetails> getCardDetailsById(@PathVariable Long id) {
        Optional<CardDetails> cardDetails = cardDetailsService.getCardDetailsById(id);
        return cardDetails.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CardDetails> createCardDetails(@RequestBody CardDetails cardDetails) {
        CardDetails savedCardDetails = cardDetailsService.saveCardDetails(cardDetails);
        return new ResponseEntity<>(savedCardDetails, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCardDetails(@PathVariable Long id) {
        cardDetailsService.deleteCardDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
