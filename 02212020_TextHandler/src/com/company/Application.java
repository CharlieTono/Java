package com.company;

import com.company.handler.Operation;
import com.company.handler.OperationProvider;
import com.company.handler.TextHandler;
import com.company.handler.operation.ToLowerCase;
import com.company.handler.operation.ToUpperCase;
import com.company.producer.TextProducer;
import com.company.service.FileOperation;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Application {

    public static final String INPUT_FILENAME = "input.txt";
    public static final String OUTPUT_FILENAME = "output.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        BlockingDeque<String> deque = new LinkedBlockingDeque<>();
        PrintWriter pw = new PrintWriter(OUTPUT_FILENAME);
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILENAME));

        FileOperation fileOperation = new FileOperation(pw, br);
 //       fileOperation.fileToDeque(deque, INPUT_FILENAME);

        Map<String, Operation> operationByName = new HashMap<>();
        operationByName.put("lowercase", new ToLowerCase());
        operationByName.put("uppercase", new ToUpperCase());

        //TODO remark this using config.props file, as was is done in calculator project

        OperationProvider operationProvider = new OperationProvider(operationByName);

        Thread[] producers = new Thread[3];
        for (int i = 0; i < producers.length; i++) {
            Thread th = new Thread(new TextProducer(fileOperation, deque));
            producers[i] = th;
            th.start();
        }

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
        br.close();
    }
}
