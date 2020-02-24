package com.company;

import com.company.operation.ToLowerCase;
import com.company.operation.ToUpperCase;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

    public static final String INPUT_FILENAME = "input.txt";
    public static final String OUTPUT_FILENAME = "output.txt";

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Deque<String> deque = new ConcurrentLinkedDeque<>();
        PrintWriter pw = new PrintWriter(OUTPUT_FILENAME);

        FileOperation fileOperation = new FileOperation(pw);
        fileOperation.fileToDeque(deque, INPUT_FILENAME);

        Map<String, Operation> operationByName = new HashMap<>();
        operationByName.put("lowercase", new ToLowerCase());
        operationByName.put("uppercase", new ToUpperCase());

        //TODO remark this using config.props file, as was is done in calculator project

        OperationProvider operationProvider = new OperationProvider(operationByName);

        Thread[] handlers = new Thread[5];

        for (int i = 0; i < handlers.length; i++) {
            Thread th = new Thread(new TextHandler(operationProvider, deque, fileOperation));
            handlers[i] = th;
            th.start();
        }

        for (Thread th : handlers) {
            th.join();
        }
        pw.close();
    }
}
