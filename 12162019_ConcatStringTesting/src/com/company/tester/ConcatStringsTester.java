package com.company.tester;

import java.util.Arrays;

public class ConcatStringsTester {

    public long test(int nStrings, String word, ConcatenatorInterfsce concantenator) {

        String[] arrayToTest = makeArray(nStrings, word);
        long now = System.currentTimeMillis();
        concantenator.concatenate(arrayToTest);

        return System.currentTimeMillis() - now;
    }

    private String[] makeArray(int nStrings, String word) {

        String [] res = new String [nStrings];
        Arrays.fill(res, word);
        return res;
    }
}
