package com.company;

import java.io.*;
import java.util.*;

public class FileOperation {

    private PrintWriter pw;

    public FileOperation(PrintWriter pw) {
        this.pw = pw;
    }

    public void fileToDeque(Collection<String> collection, String inputFilename) {

        try (BufferedReader fr = new BufferedReader(new FileReader(inputFilename))) {
            String line;
            while ((line = fr.readLine()) != null) {
                collection.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void printLine(String result) {
        synchronized (this) {
            pw.println(result);
        }
    }
}
