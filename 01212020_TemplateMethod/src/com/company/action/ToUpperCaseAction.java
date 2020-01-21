package com.company.action;

import java.util.ArrayList;
import java.util.List;

public class ToUpperCaseAction extends Action {


    public ToUpperCaseAction(String fileName, String outputFileName) {
        super(fileName, outputFileName);
    }

    @Override
    protected void perform(List<String> content) {

        List<String> temp = new ArrayList<>(content);
        content.clear();

        for (String line : temp) {
            content.add(line.toUpperCase());
        }

    }
}
