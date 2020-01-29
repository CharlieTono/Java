package com.company;

import com.company.calculator.Calculator;
import com.company.calculator.CharCalculator;
import com.company.util.FileOperations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static final String INPUT_FILENAME = "input.txt";
    public static final String OUTPUT_FILENAME = "output.txt";

    public static void main(String[] args) throws FileNotFoundException {

        FileOperations fo = new FileOperations();

        List<String> content;
        String inputFile;
        String outFile;

        if (args[0].length() != 0 || args[1].length() != 0) {
            if (args[0].length() != 0) {
                inputFile = args[0];
                try {
                    content = fo.fileToList(inputFile);
                } catch (IOException e) {
                    List<String> errorList = Arrays.asList("No file " + inputFile + " found");
                    if (args[1].length() != 0) {
                        outFile = args[1];
                        fo.listToFile(errorList, OUTPUT_FILENAME);
                        e.printStackTrace();
                        return;
                    }
                    fo.listToFile(errorList, OUTPUT_FILENAME);
                    e.printStackTrace();
                    return;
                }
            }
        }
        try {
            content = fo.fileToList(INPUT_FILENAME);
        } catch (IOException e) {
            List<String> errorList = Arrays.asList("No file " + INPUT_FILENAME + " found");
            fo.listToFile(errorList, OUTPUT_FILENAME);
            e.printStackTrace(); // print error`s info in console
            return; // stop main programme in case of this error
        }

        Calculator calculator = new CharCalculator();
        OperationProcessor processor = new OperationProcessor(calculator);
        List<String> outputContentSecond = processor.processStrings(content);

        fo.listToFile(outputContentSecond, OUTPUT_FILENAME);
    }
}


