package com.company;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

     printBuffered();
     printNonBuffered();

    }

    public static void printBuffered () throws FileNotFoundException {
       // PrintWriter pw = new PrintWriter("lines.txt");
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Hello, ");
        pw.flush();
        pw.println("World");
        pw.close();
    }

    public static void printNonBuffered () {
        PrintStream pw = new PrintStream(System.out);
        pw.println("Hello, ");
        pw.println("World");
    }
}
