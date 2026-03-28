package com.pauls.maturity_alert.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "investment_details",
        indexes = @Index(name = "idx_maturity_date", columnList = "maturityDate"))
public class InvestmentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long investId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_id", nullable = false)
    @JsonIgnore
    private CustomerDetails customer;

    @NotBlank(message = "Bank name is required")
    @Column(nullable = false)
    private String bankName;

    @NotBlank(message = "Scheme name is required")
    @Column(nullable = false)
    private String schemeName;

    @Column(nullable = false)
    @NotNull(message = "Deposit account number is required")
    private Long depositAccountNum;

    @NotNull(message = "Principal is required")
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal principal;

    @Column(nullable = false)
    @DecimalMin(value = "0.0", message = "Interest must be >= 0")
    @DecimalMax(value = "100.0", message = "Interest must be <= 100")
    @NotNull(message = "Interest rate is required")
    private Double interestRate;

    @NotNull(message = "Start date is required")
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "Maturity date is required")
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate maturityDate;

    @Column(precision = 15, scale = 2)
    private BigDecimal maturityValue;

    @Column(nullable = false)
    private Boolean autoRenew = false;

    private Long creditAccountNum;

    @Enumerated(EnumType.STRING)
    private InvestmentStatus status;

    @PrePersist
    @PreUpdate
    public void preSave() {

        // default status
        if (this.status == null) {
            this.status = InvestmentStatus.ACTIVE;
        }

        // calculate maturity value
        if (principal != null && interestRate != null) {
            double rate = interestRate / 100;
            this.maturityValue = principal.add(
                    principal.multiply(BigDecimal.valueOf(rate))
            );
        }

        if (startDate != null && maturityDate != null && maturityDate.isBefore(startDate)) {
            throw new IllegalArgumentException("Maturity date cannot be before start date");
        }
    }


    public InvestmentDetails() {}



    public InvestmentDetails(CustomerDetails customer, String bankName, String schemeName, Long depositAccountNum, BigDecimal principal, Double interestRate, LocalDate startDate, LocalDate maturityDate, Boolean autoRenew, Long creditAccountNum) {
        this.customer = customer;
        this.bankName = bankName;
        this.schemeName = schemeName;
        this.depositAccountNum = depositAccountNum;
        this.principal = principal;
        this.interestRate = interestRate;
        this.startDate = startDate;
        this.maturityDate = maturityDate;
        this.autoRenew = autoRenew;
        this.creditAccountNum = creditAccountNum;
    }

    public Long getInvestId() {
        return investId;
    }

    public void setInvestId(Long investId) {
        this.investId = investId;
    }

    public CustomerDetails getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDetails customer) {
        this.customer = customer;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public Long getDepositAccountNum() {
        return depositAccountNum;
    }

    public void setDepositAccountNum(Long depositAccountNum) {
        this.depositAccountNum = depositAccountNum;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public BigDecimal getMaturityValue() {
        return maturityValue;
    }

    public void setMaturityValue(BigDecimal maturityValue) {
        this.maturityValue = maturityValue;
    }

    public Boolean getAutoRenew() {
        return autoRenew;
    }

    public void setAutoRenew(Boolean autoRenew) {
        this.autoRenew = autoRenew;
    }

    public InvestmentStatus getStatus() {
        return status;
    }

    public void setStatus(InvestmentStatus status) {
        this.status = status;
    }

    public Long getCreditAccountNum() {
        return creditAccountNum;
    }

    public void setCreditAccountNum(Long creditAccountNum) {
        this.creditAccountNum = creditAccountNum;
    }
}