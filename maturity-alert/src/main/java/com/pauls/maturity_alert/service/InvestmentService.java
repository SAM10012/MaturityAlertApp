package com.pauls.maturity_alert.service;

import com.pauls.maturity_alert.model.CustomerDetails;
import com.pauls.maturity_alert.model.InvestmentDetails;

import java.util.List;

public interface InvestmentService {

    void addNewInvestment(InvestmentDetails investmentDetails);

    void deleteInvestmentById(long id);

    InvestmentDetails getInvestmentById(long id);

    List<InvestmentDetails> getAllInvestments();
}
