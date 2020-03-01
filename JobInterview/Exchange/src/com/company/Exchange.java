package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Exchange {

    private List<Integer> ourCoins;

    public Exchange(List<Integer> ourCoins) {
        this.ourCoins = ourCoins;
    }

    public int moneyExchange(int sumOfMoney) {
        Deque<Integer> counters = new ArrayDeque<>();
        moneyExchangeRecursion(ourCoins, sumOfMoney, sumOfMoney, 0, counters);
        int result = counters.getFirst();
        for (Integer counter : counters) {
            if (result > counter) {
                result = counter;
            }
        }
        return result;
    }

    private boolean moneyExchangeRecursion(List<Integer> coins, int sum, int sumUnchanged, int counter, Deque<Integer> counters) {

        if (sum == 0) {
            counters.addLast(counter);
            return true;
        }

        for (int i = 0; i < coins.size(); i++) {
            if (coins.get(i) <= sum) {
                counter = counter + (sum / coins.get(i));
                sum = sum % coins.get(i);
                Boolean isFull = moneyExchangeRecursion(coins, sum, sumUnchanged, counter, counters);
                if (isFull) {
                    if (counters.size() != coins.size()) {
                        coins.remove(0);
                        moneyExchangeRecursion(coins, sumUnchanged, sumUnchanged, 0, counters);
                    }
                    return true;
                }
            }
        }
        counters.addLast(0);
        return false;
    }
}
