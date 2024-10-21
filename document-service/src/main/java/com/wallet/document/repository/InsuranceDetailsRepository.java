package com.wallet.document.repository;

import com.wallet.document.model.InsuranceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InsuranceDetailsRepository extends JpaRepository<InsuranceDetails, Long> {
}
