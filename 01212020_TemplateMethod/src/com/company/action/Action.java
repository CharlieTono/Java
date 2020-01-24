package com.company.action;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Action {

    protected String fileName;
    protected String outputFileName;

    public Action(String fileName, String outputFileName) {
        this.fileName = fileName;
        this.outputFileName = outputFileName;
    }

    public void performAction() throws IOException {
        List<String> content = fileToList();
        perform(content);
        listToFile(content);
    }

    protected abstract void perform(List<String> content);

    private List<String> fileToList() throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            List<String> list = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            return list;
        }

//        FileInputStream fis = new FileInputStream(fileName);
//        int length = fis.available();
//        byte[] bytes = new byte[length];
//        fis.read(bytes);
//        fis.close();
//
//        List<String> list = new ArrayList<>();
//        String text = new String(bytes);
//        String[] newText = text.split(" ");
//
//        for (String newString : newText) {
//            list.add(String.valueOf(newString + " "));
//        }
//
//        return list;
    }

    private void listToFile(List<String> content) throws FileNotFoundException {

        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            for (String line : content) {
                pw.println(line);
            }
        }

//        StringBuilder text = new StringBuilder();
//
//        for (String current : content) {
//            text.append(current);
//        }
//
//        String newText = text.toString();
//
//        FileOutputStream fos = new FileOutputStream(outputFileName);
//        fos.write(newText.getBytes());
//        fos.close();

    }
}
