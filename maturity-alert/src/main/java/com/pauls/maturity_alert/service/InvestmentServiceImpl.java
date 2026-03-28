package com.pauls.maturity_alert.service;

import com.pauls.maturity_alert.model.CustomerDetails;
import com.pauls.maturity_alert.model.InvestmentDetails;
import com.pauls.maturity_alert.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestmentServiceImpl implements InvestmentService{

    @Autowired
    private InvestmentRepository investmentRepository;

    @Override
    public void addNewInvestment(InvestmentDetails investmentDetails) {
        investmentRepository.save(investmentDetails);
    }

    @Override
    public void deleteInvestmentById(long id) {
        investmentRepository.deleteById(id);
    }

    @Override
    public InvestmentDetails getInvestmentById(long id) {

        Optional<InvestmentDetails> optional = investmentRepository.findById(id);

        InvestmentDetails investmentDetails = null;

        if(optional.isPresent())
        {
            investmentDetails = optional.get();
        }
        else {
            throw new RuntimeException("There is no such Investment ID.");
        }

        return investmentDetails;
    }

    @Override
    public List<InvestmentDetails> getAllInvestments() {
        return investmentRepository.findAll();
    }

    @Override
    public List<InvestmentDetails> getAllInvestmentsByCustId(Long id) {
        return investmentRepository.getAllInvestmentsByCustId(id);
    }
}
