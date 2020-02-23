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

    public static void main(String[] args) throws FileNotFoundException {
        Deque<String> deque = new ConcurrentLinkedDeque<>();

        FileOperation fileOperation = new FileOperation();
        fileOperation.fileToDeque(deque, "inputText.txt");

        Map<String, Operation> operationByName = new HashMap<>();
        operationByName.put("lowercase", new ToLowerCase());
        operationByName.put("uppercase", new ToUpperCase());

        //TODO remark this using config.props file, as was is done in calculator project

        OperationProvider operationProvider = new OperationProvider(operationByName);
        PrintWriter pw = new PrintWriter("outputText.txt");

        Thread[] handlers = new Thread[5];

        for (int i = 0; i < handlers.length; i++) {
            Thread th = new Thread(new TextHandler(operationProvider, deque, pw));
            handlers[i] = th;
            th.start();
        }
        pw.close();
    }
}
