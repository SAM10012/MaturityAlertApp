package com.pauls.maturity_alert.service;

public interface EmailService {

    void sendEmail(String to, String subject, String body);

}