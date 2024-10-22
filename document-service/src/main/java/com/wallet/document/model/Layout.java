package com.wallet.document.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public class Layout {

    @NotNull(message="family id is required")
    private Long familyId;

    @NotBlank(message="name is required")
    private String nameInDocument;

    @Id
    @GeneratedValue
    private Long id;
}
