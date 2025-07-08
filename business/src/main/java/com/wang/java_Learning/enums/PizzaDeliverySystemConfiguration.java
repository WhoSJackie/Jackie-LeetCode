package com.wang.java_Learning.enums;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum PizzaDeliverySystemConfiguration {

    INSTANCE;

    private PizzaDeliveryStrategy deliveryStrategy = PizzaDeliveryStrategy.NORMAL;

    public static PizzaDeliverySystemConfiguration getInstance() {
        return INSTANCE;
    }

    public PizzaDeliveryStrategy getDeliveryStrategy() {
        return deliveryStrategy;
    }

}
