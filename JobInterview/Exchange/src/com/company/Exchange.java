package com.company;

import java.util.*;

public class Exchange {

    private List<Integer> ourCoins;

    public Exchange(List<Integer> ourCoins) {
        this.ourCoins = ourCoins;
    }

    public int moneyExchange(int sumOfMoney) {
        Deque<Integer> coinsResult = new ArrayDeque<>();
        moneyExchangeRecursion(ourCoins, sumOfMoney, coinsResult, 0);
        int result = coinsResult.size();
        return result;
    }

    private boolean moneyExchangeRecursion(List<Integer> coins, int sum, Deque<Integer> coinsResult, int index) {

        if (sum == 0) {
            return true;
        }

        for (int i = index; i < coins.size(); i++) {
            if (sum % coins.get(i) == 0) {
                while (sum != 0) {
                    sum = sum - coins.get(i);
                    coinsResult.addLast(coins.get(i));
                }
                return true;
            }
            if (sum >= coins.get(i)) {
                sum = sum - coins.get(i);
                coinsResult.addLast(coins.get(i));
                Boolean isFull = moneyExchangeRecursion(coins, sum, coinsResult, index + 1);
                if (isFull) {
                    return true;
                } else {
                    int numberToRemove = coinsResult.removeFirst();
                    sum = sum + numberToRemove;
                }
            }
        }
        return false;
    }
}
