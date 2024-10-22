package com.wallet.document.repository;

import com.wallet.document.model.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {
    List<BankDetails> findByFamilyId(int familyId);
}
