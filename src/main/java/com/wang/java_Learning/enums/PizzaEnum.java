package com.wang.java_Learning.enums;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PizzaEnum {

    private static EnumSet<PizzaStatus> undeliveredPizzaStatuses =
            EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY);

    public static EnumMap<PizzaStatus, List<PizzaEnum>> groupPizzaByStatus(List<PizzaEnum> pizzaList) {
        EnumMap<PizzaStatus, List<PizzaEnum>> pzByStatus = new EnumMap<PizzaStatus, List<PizzaEnum>>(PizzaStatus.class);
        for (PizzaEnum pz : pizzaList) {
            PizzaStatus status = pz.getStatus();
            if (pzByStatus.containsKey(status)) {
                pzByStatus.get(status).add(pz);
            } else {
                List<PizzaEnum> newPzList = new ArrayList<PizzaEnum>();
                newPzList.add(pz);
                pzByStatus.put(status, newPzList);
            }
        }
        return pzByStatus;
    }

    private PizzaStatus status;

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " + this.getStatus().getTimeToDelivery() + " days");
    }

    public static List<PizzaEnum> getAllUndeliveredPizzas(List<PizzaEnum> input) {
        return input.stream().filter(
                (s) -> undeliveredPizzaStatuses.contains(s.getStatus()))
                .collect(Collectors.toList());
    }

    public void deliver() {
        if (isDeliverable()) {
            PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy().deliver(this);
            this.setStatus(PizzaStatus.DELIVERED);
        }
    }

    public static void main(String[] args) {
        PizzaEnum set = new PizzaEnum();
        set.setStatus(PizzaStatus.DELIVERED);
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(set));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
