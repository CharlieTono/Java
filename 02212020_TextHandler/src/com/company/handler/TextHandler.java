package com.company.handler;

import com.company.service.FileOperation;

import java.util.concurrent.BlockingDeque;

public class TextHandler implements Runnable {

    private static final String DELIMITER = "#";
    static final String WRONG_OPERATION_TYPE = "Incorrect operation type";
    static final String WRONG_TEXT_TYPE = "Incorrect text type";

    private OperationProvider op;

    private BlockingDeque<String> lines;

    private final FileOperation fileOperation;

    public TextHandler(OperationProvider op, BlockingDeque lines, FileOperation fileOperation) {
        this.op = op;
        this.lines = lines;
        this.fileOperation = fileOperation;
    }

    @Override
    public void run() {
        while (true) {
            String line = lines.pollFirst();
            if (lines == null || line == null) {
                return;
            } else {
                String[] parts = line.split(DELIMITER);
                String text = parts[0];
                String result;
                if (parts.length != 2 || text.length() == 0) {
                    result = line + ": " + WRONG_TEXT_TYPE;
                } else {
                    String operationName = parts[1];
                    Operation operation = op.getByName(operationName);
                    if (operation == null) {
                        result = line + ": " + WRONG_OPERATION_TYPE;
                    } else {
                        result = operation.operate(text);
                    }
                }
                fileOperation.printLine(result);
            }
        }
    }
}
