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
public class CertificateDetails {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Certificate number is required")
    private String certificateNumber;

    @NotBlank(message = "Certificate name is required")
    private String certificateName; // New field for the name of the certificate

    @NotBlank(message = "Name on the certificate is required")
    private String name; // Name on the certificate

    private LocalDate issueDate;
    private LocalDate expiryDate;
}
