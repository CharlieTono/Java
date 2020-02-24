package com.company.operation;

import com.company.Operation;

public class ToLowerCase implements Operation {

    private static final String NAME = "lowercase";

    @Override
    public String operate(String word) {
        word = word.toLowerCase();
        return word;
    }

    @Override
    public String getName() {
        return NAME;
    }

}
