package com.pauls.maturity_alert.runner;

import com.pauls.maturity_alert.service.ReminderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private ReminderServiceImpl reminderService;

    @Override
    public void run(String... args) throws Exception {
        reminderService.sendMaturityReminders();
    }
}