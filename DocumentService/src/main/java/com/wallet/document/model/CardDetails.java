package com.wallet.document.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CardDetails {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Card number is required")
    private String cardNumber;

    @NotBlank(message = "Card Holder name is required")
    private String cardHolderName;

    @NotBlank(message = "Card expiry date is required")
    private LocalDate expiryDate; // Consider using LocalDate

    @NotBlank(message = "Card Type is required")
    private LocalDate cardType; // e.g., Credit, Debit

    @NotBlank(message = "Associated bank id is required")
    private Long bankId;

}
