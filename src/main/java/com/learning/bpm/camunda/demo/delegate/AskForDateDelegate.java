package com.learning.bpm.camunda.demo.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AskForDateDelegate implements JavaDelegate {

    public static final Logger LOGGER = LoggerFactory.getLogger(AskForDateDelegate.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.setVariable("message", "When are you available?");
        LOGGER.info("Asking for a date [{}]", delegateExecution.getProcessBusinessKey());
    }
}
