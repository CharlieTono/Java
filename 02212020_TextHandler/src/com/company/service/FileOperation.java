package com.company.service;

import java.io.*;
import java.util.*;

public class FileOperation {

    private PrintWriter pw;
    private BufferedReader br;

    public FileOperation(PrintWriter pw, BufferedReader br) {
        this.pw = pw;
        this.br = br;
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

    public String readLine() throws IOException {
        return br.readLine();
    }
}
