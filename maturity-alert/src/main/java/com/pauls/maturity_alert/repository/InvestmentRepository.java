package com.pauls.maturity_alert.repository;

import com.pauls.maturity_alert.model.InvestmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentRepository extends JpaRepository<InvestmentDetails,Long> {
}
