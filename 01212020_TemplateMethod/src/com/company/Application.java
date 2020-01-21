package com.company;

import com.company.action.Action;
import com.company.action.ReverseAction;
import com.company.action.SortAction;
import com.company.action.ToUpperCaseAction;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {

        Action reverse = new ReverseAction("text.txt", "reverseText.txt");
        reverse.performAction();

        Action sort = new SortAction("text.txt", "sortText.txt");
        sort.performAction();

        Action toUpper = new ToUpperCaseAction("text.txt", "toUpperText.txt");
        toUpper.performAction();

    }
}
