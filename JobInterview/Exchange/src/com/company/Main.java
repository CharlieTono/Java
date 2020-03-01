package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> ourCoins01 = new ArrayList(Arrays.asList(5,4,1));
        List<Integer> ourCoins02 = new ArrayList(Arrays.asList(5,4,2));
        List<Integer> ourCoins03 = new ArrayList(Arrays.asList(4,2,1));
        int sum = 13;
        Exchange exchange01 = new Exchange(ourCoins01);
        Exchange exchange02 = new Exchange(ourCoins02);
        Exchange exchange03 = new Exchange(ourCoins03);
        int result01 = exchange01.moneyExchange(sum);
        int result02 = exchange02.moneyExchange(sum);
        int result03 = exchange03.moneyExchange(sum);
        System.out.println(result01);
        System.out.println(result02);
        System.out.println(result03);
    }
}
