package com.wallet.document.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="family id is required")
    private int familyId;
    @NotBlank(message="first name is required")
    private String firstName;
    @NotBlank(message="last name is required")
    private String lastName;
    @NotBlank(message="email is required")
    private String email;
    @NotBlank(message="phoneNumber is required")
    private String phoneNumber;
    @NotBlank(message="dateOfBirth is required")
    private LocalDate dateOfBirth;
}
