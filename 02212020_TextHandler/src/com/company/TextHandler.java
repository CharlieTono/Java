package com.company;

import java.io.PrintWriter;
import java.util.Deque;

public class TextHandler implements Runnable {

    private static final String DELIMITER = "#";
    static final String WRONG_OPERATION_TYPE = "Incorrect operation type";
    static final String WRONG_TEXT_TYPE = "Incorrect text type";

    private OperationProvider op;

    private Deque<String> lines;

    private PrintWriter printWriter;

    public TextHandler(OperationProvider op, Deque lines, PrintWriter printWriter) {
        this.op = op;
        this.lines = lines;
        this.printWriter = printWriter;
    }

    @Override
    public void run() {
        while (true) {
            String line = lines.pollLast();
            if (lines == null || line == null) {
                return;
            } else {
                String[] parts = line.split(DELIMITER);
                String text = parts[0];
                if (parts.length != 2 || text.length() == 0) {
                    System.out.println(line + ": " + WRONG_TEXT_TYPE);
                } else {
                    String operationName = parts[1];
                    Operation operation = op.getByName(operationName);
                    if (operation == null) {
                        System.out.println(line + ": " + WRONG_OPERATION_TYPE);
                    } else {
                        String result = operation.operate(text);
                        printWriter.println(result);
                    }
                }
            }
        }
    }
}
