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
@Inheritance (strategy = InheritanceType.JOINED)
public class Layout {

    @NotBlank(message="family id is required")
    private int familyId;

    @NotBlank(message="name is required")
    private int nameInDocument;

    @Id
    @GeneratedValue
    private int id;
}
