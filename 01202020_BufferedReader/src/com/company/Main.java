package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text;

        while ((text = br.readLine()) != null && !text.equalsIgnoreCase("exit")) {
            System.out.println(text + " , hallo!");
        }
    }

    public static void readLinesFromFiles() throws IOException {
        List<String> lines = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader("lines.txt"));

        String text;

        while ((text = br.readLine()) != null) {
            System.out.println(text);
        }
    }
}
