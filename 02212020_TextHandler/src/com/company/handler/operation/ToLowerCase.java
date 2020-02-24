package com.company.handler.operation;

import com.company.handler.Operation;

public class ToLowerCase implements Operation {

    private static final String NAME = "lowercase";

    @Override
    public String operate(String word) {
        return word.toLowerCase();
    }

    @Override
    public String getName() {
        return NAME;
    }

}
