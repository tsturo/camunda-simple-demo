package com.learning.bpm.camunda.demo.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BookTableDelegate implements JavaDelegate {

    public static final Logger LOGGER = LoggerFactory.getLogger(BookTableDelegate.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.setVariable("tableBooked", true);
        LOGGER.info("Booking table in the {} restaurant [{}]", delegateExecution.getVariable("restaurant"), delegateExecution.getProcessBusinessKey());
    }
}
