package com.wallet.document.repository;

import com.wallet.document.model.GovtIdDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GovtIdDetailsRepository extends JpaRepository<GovtIdDetails, Long> {
}
