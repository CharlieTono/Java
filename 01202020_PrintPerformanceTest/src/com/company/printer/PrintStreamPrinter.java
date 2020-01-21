package com.company.printer;

import java.io.PrintStream;

public class PrintStreamPrinter implements PrinterInterface {

    PrintStream ps;

    public PrintStreamPrinter(PrintStream ps) {
        this.ps = ps;
    }

    @Override
    public void printLine(String line) {
        ps.println(line);
    }

    @Override
    public void close() {
        ps.close();
    }
}
