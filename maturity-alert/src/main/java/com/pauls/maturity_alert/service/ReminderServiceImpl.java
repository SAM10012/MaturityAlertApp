package com.pauls.maturity_alert.service;

import com.pauls.maturity_alert.model.InvestmentDetails;
import com.pauls.maturity_alert.model.CustomerDetails;
import com.pauls.maturity_alert.repository.InvestmentRepository;
import com.pauls.maturity_alert.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReminderServiceImpl {

    @Autowired
    private InvestmentRepository investmentRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmailService emailService;

    @Transactional
    public void sendMaturityReminders() {

        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusDays(7);

        // Get investments maturing within next 7 days
        List<InvestmentDetails> investments =
                investmentRepository.findInvestmentsMaturingSoon(today, nextWeek);

        for (InvestmentDetails inv : investments) {

            CustomerDetails customer = inv.getCustomer();

            if (customer != null) {

                String subject = "Maturity Reminder for " + inv.getSchemeName();

                String body = "Hello " + customer.getCustName() + ",\n\n"
                        + "Your investment in " + inv.getSchemeName()
                        + " is maturing on " + inv.getMaturityDate() + ".\n"
                        + "Maturity Value: " + inv.getMaturityValue() + "\n\n"
                        + "Regards,\nMaturityAlert Team\n\nThis is a Test Email. Please ignore it.";

                emailService.sendEmail(
                        customer.getCustEmail(),
                        subject,
                        body
                );
            }
        }
    }
}