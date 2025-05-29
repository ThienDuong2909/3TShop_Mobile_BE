package com.project._TShop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AuthenticationFactory {


    private final Map<String, AuthenticationStrategy> strategies;

    @Autowired
    public AuthenticationFactory(List<AuthenticationStrategy> strategyList) {
        strategies = new HashMap<>();
        for (AuthenticationStrategy strategy : strategyList) {
            strategies.put(strategy.getClass().getAnnotation(Component.class).value(), strategy);
        }
    }

    public AuthenticationStrategy getStrategy(String type) {
        return strategies.get(type);
    }
}