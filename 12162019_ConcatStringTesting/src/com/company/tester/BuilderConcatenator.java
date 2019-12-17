package com.company.tester;

public class BuilderConcatenator implements ConcatenatorInterfsce {

    @Override
    public String concatenate(String[] strings) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            builder.append(strings[i]);
        }
        String res = builder.toString();

        return res;
    }
}
