package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AccFilter {

    public List<Account> filter(List<Account> clients, Predicate<Account> finalDecision) {
        List<Account> approvedClients = new ArrayList<>();
        for (int i = 0; i < clients.size(); i++) {
            if (finalDecision.test(clients.get(i))) {
                approvedClients.add(clients.get(i));
            }
        }
        return approvedClients;
    }
}
