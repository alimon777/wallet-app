package com.wallet.document.repository;

import com.wallet.document.model.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {
}
