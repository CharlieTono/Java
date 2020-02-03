package com.company.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

    public List<String> fileToList(String inputFilename) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilename))) {
            List<String> list = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            return list;
        }
    }

    public void listToFile(List<String> content, String outputFilename) throws FileNotFoundException {

        try (PrintWriter pw = new PrintWriter(outputFilename)) {
            for (String line : content) {
                pw.println(line);
            }
        }
    }
}

