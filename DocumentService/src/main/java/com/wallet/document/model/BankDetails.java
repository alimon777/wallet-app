package com.wallet.document.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BankDetails {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Account number is required")
    private String accountNumber;

    @NotBlank(message = "Bank name is required")
    private String bankName;

    @NotBlank(message = "Account holder's name is required")
    private String holderName;

    @NotBlank(message = "IFSC code is required")
    private String ifscCode; // IFSC code

    @NotBlank(message = "Branch name is required")
    private String branch; // Branch name

    private Long noOfCards; // Linking card details to bank
}
