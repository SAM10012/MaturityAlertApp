package com.pauls.maturity_alert.repository;

import com.pauls.maturity_alert.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerDetails,Long> {
}
