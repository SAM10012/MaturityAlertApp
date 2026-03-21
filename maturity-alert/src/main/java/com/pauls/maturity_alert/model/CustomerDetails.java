package com.pauls.maturity_alert.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name = "customer_details")
public class CustomerDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custId;

    @NotBlank(message = "Name is required")
    private String custName;

    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number")
    private String custPhone;

    @Email(message = "Invalid email format")
    private String custEmail;


    public CustomerDetails(){}

    public CustomerDetails(String custName, String custPhone, String custEmail) {
        this.custName = custName;
        this.custPhone = custPhone;
        this.custEmail = custEmail;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }
}

