package com.pauls.maturity_alert.controller;

import com.pauls.maturity_alert.model.CustomerDetails;
import com.pauls.maturity_alert.model.InvestmentDetails;
import com.pauls.maturity_alert.service.CustomerService;
import com.pauls.maturity_alert.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/investment/new/{id}")
    public String addNewInvestment(@PathVariable(value = "id") Long id, Model model) {
        InvestmentDetails investmentDetails = new InvestmentDetails();

        CustomerDetails customerDetails = customerService.getCustomerById(id);
        investmentDetails.setCustomer(customerDetails);

        model.addAttribute("investDetails", investmentDetails);
        return "new-investment-form";
    }


    @PostMapping("/investment/save")
    public String saveInvestDetails(@ModelAttribute("investDetails") InvestmentDetails investmentDetails) {
        investmentService.addNewInvestment(investmentDetails);
        return "redirect:/";
    }

    @GetMapping("/investments/view")
    public String viewInvestments(Model model) {
        model.addAttribute("allInvestments", investmentService.getAllInvestments());
        return "show-all-investments";
    }

    @GetMapping("/investments/view/{id}")
    public String viewCustInvestments(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("custInvestments", investmentService.getAllInvestmentsByCustId(id));
        model.addAttribute("custName",customerService.getCustomerById(id).getCustName());
        return "show-cust-investments";
    }

    @GetMapping("/update-investment/{id}")
    public String updateInvestment(@PathVariable(value = "id") Long id, Model model) {
        InvestmentDetails investmentDetails = investmentService.getInvestmentById(id);

        //Force load customer
        investmentDetails.getCustomer().getCustId();

        model.addAttribute("investDetails", investmentDetails);
        return "update-investment-form";
    }

    @GetMapping("/delete-investment/{id}")
    public String deleteInvestment(@PathVariable(value = "id") int id) {
        investmentService.deleteInvestmentById(id);
        return "redirect:/";
    }
}









