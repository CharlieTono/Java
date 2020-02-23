package com.company.operation;

import com.company.Operation;

public class ToUpperCase implements Operation {

    private static final String NAME = "uppercase";

    @Override
    public String operate(String word) {
        word = word.toUpperCase();
        return word;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
