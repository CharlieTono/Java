package com.company.handler.operation;

import com.company.handler.Operation;

public class ToUpperCaseOperation implements Operation {

    private static final String NAME = "uppercase";

    @Override
    public String operate(String word) {
        return word.toUpperCase();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
