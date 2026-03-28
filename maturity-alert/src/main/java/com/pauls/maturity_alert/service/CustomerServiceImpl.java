package com.pauls.maturity_alert.service;

import com.pauls.maturity_alert.model.CustomerDetails;
import com.pauls.maturity_alert.model.InvestmentDetails;
import com.pauls.maturity_alert.repository.CustomerRepository;
import com.pauls.maturity_alert.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private InvestmentRepository investmentRepository;


    @Override
    public void addNewCustomer(CustomerDetails customerDetails) {
        customerRepository.save(customerDetails);

    }

    @Override
    public void deleteCustomerById(long id) {

        List<InvestmentDetails> investments =
                investmentRepository.getAllInvestmentsByCustId(id);
        if(!investments.isEmpty()) {
            throw new RuntimeException("Cannot delete customer with active investments");
        }

        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDetails getCustomerById(long id) {

        Optional<CustomerDetails> optional = customerRepository.findById(id);

        CustomerDetails customerDetails = null;

        if(optional.isPresent())
        {
            customerDetails = optional.get();
        }
        else {
            throw new RuntimeException("There is no such Customer ID.");
        }

        return customerDetails;
    }

    @Override
    public List<CustomerDetails> getAllCustomers() {
        return customerRepository.findAll();
    }
}
