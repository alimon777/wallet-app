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
public class VisaDetails {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Visa type is required")
    private String visaType; // Type of visa (e.g., tourist, student, work)

    @NotBlank(message = "Visa number is required")
    private String visaNumber; // Visa number

    @NotBlank(message = "Country of issue is required")
    private String countryOfIssue; // The country that issued the visa

    @NotNull(message = "Visa issue date is required")
    private LocalDate issueDate; // Visa issue date

    @NotNull(message = "Visa expiry date is required")
    private LocalDate expiryDate; // Visa expiry date
}