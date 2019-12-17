package com.company.tester;

public class StringConcatenator implements ConcatenatorInterfsce {

    @Override
    public String concatenate(String[] strings) {
        String res = "";
        for (int i = 0; i < strings.length; i++) {
            res += strings[i];
        }
        return res;
    }
}
