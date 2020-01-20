package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String hello = " Hello world! ";
        FileOutputStream fos = new FileOutputStream("temp.txt", true); // with "true" only adds data into file; without "true" creates new file
        fos.write(hello.getBytes());
        fos.close();

        FileInputStream fis = new FileInputStream("temp.txt");
        int length = fis.available();
        byte[] bytes = new byte[length];
        fis.read(bytes);
        fis.close();

        System.out.println(new String (bytes));

    }
}
