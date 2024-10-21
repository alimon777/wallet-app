package com.wallet.document.repository;

import com.wallet.document.model.CertificateDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateDetailsRepository extends JpaRepository<CertificateDetails, Long> {
}
