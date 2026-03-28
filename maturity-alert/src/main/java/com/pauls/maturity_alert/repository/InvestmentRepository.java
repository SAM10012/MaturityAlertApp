package com.pauls.maturity_alert.repository;

import com.pauls.maturity_alert.model.InvestmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvestmentRepository extends JpaRepository<InvestmentDetails,Long> {

    @Query("SELECT i FROM InvestmentDetails i WHERE i.customer.custId = :custId")
    List<InvestmentDetails> getAllInvestmentsByCustId(@Param("custId") Long custId);
}
