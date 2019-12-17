package com.company;

import com.company.tester.BuilderConcatenator;
import com.company.tester.ConcatStringsTester;
import com.company.tester.ConcatenatorInterfsce;
import com.company.tester.StringConcatenator;

public class Application {

    public static void main(String[] args) {

        ConcatStringsTester tester = new ConcatStringsTester();
        ConcatenatorInterfsce stringConcatenator = new StringConcatenator();
        ConcatenatorInterfsce builderoncatenator = new BuilderConcatenator();

        System.out.println(tester.test(100000, "hello", stringConcatenator));
        System.out.println(tester.test(100000, "hello", builderoncatenator));

    }
}
