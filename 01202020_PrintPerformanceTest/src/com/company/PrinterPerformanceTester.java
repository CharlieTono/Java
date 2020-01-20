package com.company;

import com.company.printer.PrinterInterface;

public class PrinterPerformanceTester {

    PrinterInterface pi;

    PrinterPerformanceTester(PrinterInterface pi) {
        this.pi = pi;
    }

    public long testNLines(int n, String text) {

        long now = System.currentTimeMillis();

        while (n > 0) {
            pi.printLine(text);
            n--;
        }
        pi.close();
        return System.currentTimeMillis() - now;
    }
}
