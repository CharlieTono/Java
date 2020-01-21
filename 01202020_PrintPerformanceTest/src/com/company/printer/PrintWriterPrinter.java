package com.company.printer;

import java.io.PrintWriter;

public class PrintWriterPrinter implements PrinterInterface {

    PrintWriter pw;

    public PrintWriterPrinter(PrintWriter pw) {
        this.pw = pw;
    }

    @Override
    public void printLine(String line) {
        pw.println(line);
    }

    @Override
    public void close() {
        pw.close();
    }
}
