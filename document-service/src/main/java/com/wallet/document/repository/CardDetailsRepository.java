package com.wallet.document.repository;

import com.wallet.document.model.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDetailsRepository extends JpaRepository<CardDetails, Long> {
}
