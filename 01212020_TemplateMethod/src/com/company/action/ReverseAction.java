package com.company.action;

import java.util.Collections;
import java.util.List;

public class ReverseAction extends Action {

    public ReverseAction(String fileName, String outputFileName) {
        super(fileName, outputFileName);
    }

    @Override
    protected void perform(List<String> content) {
        Collections.reverse(content);
    }
}
