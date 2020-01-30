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

    /**
     * @param args args[0] input filename if present, args[1] output filename if present
     * @throws FileNotFoundException if output filename is not legal
     */

    public static void main(String[] args) throws FileNotFoundException {

        List<String> content;
        String inputFile = args.length > 0 ? args[0] : INPUT_FILENAME;
        String outfile = args.length > 1 ? args[1] : OUTPUT_FILENAME;

        FileOperations fo = new FileOperations();

        try {
            content = fo.fileToList(inputFile);
        } catch (IOException e) {
            List<String> errorList = Arrays.asList("No file " + inputFile + " found");
            fo.listToFile(errorList, outfile);
            e.printStackTrace(); // print error`s info in console
            return; // stop main programme in case of this error
        }

        Calculator calculator = new CharCalculator();
        OperationProcessor processor = new OperationProcessor(calculator);
        List<String> outputContentSecond = processor.processStrings(content);

        fo.listToFile(outputContentSecond, outfile);
    }
}


