package com.wallet.document.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InsuranceDetails {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Insurance provider name is required")
    private String providerName; // Name of the insurance provider

    @NotBlank(message = "Policy number is required")
    private String policyNumber; // Insurance policy number

    @NotNull(message = "Policy start date is required")
    private LocalDate issueDate; // Policy start date

    @NotNull(message = "Policy end date is required")
    private LocalDate expiryDate; // Policy end date

    @NotBlank(message = "Insurance type is required")
    private String insuranceType; // Type of insurance (e.g., health, life, auto)
}
