package com.company;

import java.io.*;
import java.util.*;

public class FileOperation {

    public Deque<String> fileToDeque(Deque<String> ourDeque, String inputFilename) {

        try (BufferedReader fr = new BufferedReader(new FileReader(inputFilename))) {
            String line;
            while ((line = fr.readLine()) != null) {
                ourDeque.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ourDeque;
    }

}
