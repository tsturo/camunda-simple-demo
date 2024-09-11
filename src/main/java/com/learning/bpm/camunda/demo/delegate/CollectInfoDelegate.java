package com.learning.bpm.camunda.demo.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CollectInfoDelegate implements JavaDelegate {

    public static final Logger LOGGER = LoggerFactory.getLogger(CollectInfoDelegate.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Map<String, Object> variables = getInformationFromSocialMedia();
        delegateExecution.setVariables(variables);
        delegateExecution.setVariable("budget", "Luxury");

        LOGGER.info("Collecting information [{}]", delegateExecution.getProcessBusinessKey());
    }

    private Map<String, Object> getInformationFromSocialMedia() {
        return Map.of(
                "favouriteRestaurant", "The Great Restaurant",
                "favouriteCuisine", "Italian",
                "favouriteDish", "Pizza",
                "favouriteDrink", "Vine",
                "favouriteLocation", "City center",
                "favouriteDessert", "Ice Cream",
                "isVegan", true,
                "requiresGlutenFree", true
        );
    }
}
