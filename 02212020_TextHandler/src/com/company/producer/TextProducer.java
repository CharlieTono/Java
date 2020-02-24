package com.company.producer;

import com.company.service.FileOperation;

import java.io.IOException;
import java.util.concurrent.BlockingDeque;

public class TextProducer implements Runnable {

    private FileOperation fileOperation;

    private BlockingDeque<String> blockingDeque; //BlockingDeque is making the thread sleeping, when nothing is adding

    public TextProducer(FileOperation fileOperation, BlockingDeque<String> blockingDeque) {
        this.fileOperation = fileOperation;
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        try {
            String line;
            while ((line = fileOperation.readLine()) != null) {
                blockingDeque.addLast(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
