package com.wallet.document.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"idType"}, name = "UniqueGovtIdPerPerson")
})
public class GovtIdDetails extends Layout {
    @NotBlank(message = "ID type can't be blank")
    private String idType; // Should be restricted to specific types like Aadhar, PAN, etc.

    @NotBlank(message = "ID number can't be blank")
    private String idNumber;

    private LocalDate issueDate; // Optional

    private LocalDate expiryDate; // Optional
}