package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {

        List<Integer> list = new ArrayList<>() {};
        list.add(1);
        list.add(8);
        list.add(239);

        writeFile(list);

        List<Integer> list2 = readFile();
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i));
        }
    }

    public static void writeFile(List<Integer> list) throws IOException {

        StringBuilder text = new StringBuilder();

        for (Integer current : list) {
            text.append(current);
            text.append(" ");
        }

        String newText = text.toString();

        FileOutputStream fos = new FileOutputStream("temp.txt");
        fos.write(newText.getBytes());
        fos.close();
    }

    public static List<Integer> readFile() throws IOException {

        FileInputStream fis = new FileInputStream("temp.txt");
        int length = fis.available();
        byte[] bytes = new byte[length];
        fis.read(bytes);
        fis.close();

        String text = new String(bytes);

        String[] newText = text.split(" ");

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < newText.length; i++) {
            String newString = newText[i];
            list.add(Integer.valueOf(newString));
        }
        return list;
    }

}
