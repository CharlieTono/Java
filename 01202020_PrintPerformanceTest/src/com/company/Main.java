package com.company;

import com.company.printer.PrintStreamPrinter;
import com.company.printer.PrintWriterPrinter;
import com.company.printer.PrinterInterface;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        PrinterInterface printStreamWrapper = new PrintStreamPrinter(new PrintStream(new FileOutputStream("printStream.txt")));

        PrinterInterface printWriterWrapper = new PrintWriterPrinter(new PrintWriter("printWriter.txt"));

        PrinterPerformanceTester ppt = new PrinterPerformanceTester(printStreamWrapper);
        System.out.println("Result of PrintStream is: ");
        System.out.println(ppt.testNLines(10000, "Hello"));

        ppt = new PrinterPerformanceTester(printWriterWrapper);
        System.out.println("Result of PrintWriter is: ");
        System.out.println(ppt.testNLines(10000, "Hello"));

    }
}
