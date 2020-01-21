package com.company.action;

import java.util.Collections;
import java.util.List;

public class SortAction extends Action {

    public SortAction(String fileName, String outputFileName) {
        super(fileName, outputFileName);
    }

    @Override
    protected void perform(List<String> content) {
        Collections.sort(content);
    }
}
