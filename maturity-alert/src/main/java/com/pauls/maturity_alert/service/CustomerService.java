package com.pauls.maturity_alert.service;

import com.pauls.maturity_alert.model.CustomerDetails;

import java.util.List;

public interface CustomerService {


    void addNewCustomer(CustomerDetails customerDetails);

    void deleteCustomerById(long id);

    CustomerDetails getCustomerById(long id);

    List<CustomerDetails> getAllCustomers();
}
