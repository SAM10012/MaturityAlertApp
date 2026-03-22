package com.pauls.maturity_alert.controller;

import com.pauls.maturity_alert.model.CustomerDetails;
import com.pauls.maturity_alert.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String viewHomePage() {
        return "homepage";
    }

    @GetMapping("/customer/new")
    public String addNewCustomer(Model model) {
        CustomerDetails customerDetails = new CustomerDetails();
        model.addAttribute("custDetails", customerDetails);
        return "new-customer-form";
    }


    @PostMapping("/customer/save")
    public String saveCustDetails(@ModelAttribute("custDetails") CustomerDetails customerDetails) {
        customerService.addNewCustomer(customerDetails);
        return "redirect:/";
    }

    @GetMapping("/customers/view")
    public String viewCustomers(Model model) {
        model.addAttribute("allCustomers", customerService.getAllCustomers());
        return "show-all-customers";
    }

    @GetMapping("/update-customer/{id}")
    public String updateCustomer(@PathVariable(value = "id") int id, Model model) {
        CustomerDetails customerDetails = customerService.getCustomerById(id);
        model.addAttribute("custDetails", customerDetails);
        return "update-customer-form";
    }

    @GetMapping("/delete-customer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id) {
        customerService.deleteCustomerById(id);
        return "redirect:/";
    }
}

