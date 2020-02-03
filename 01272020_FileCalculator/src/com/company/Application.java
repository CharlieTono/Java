package com.company;

import com.company.calculator.Calculator;
import com.company.calculator.ModernCalculator;
import com.company.calculator.OperationManager;
import com.company.util.FileOperations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Application {

    public static final String INPUT_FILENAME = "input.txt";
    public static final String OUTPUT_FILENAME = "output.txt";

    /**
     * @param args args[0] input filename if present, args[1] output filename if present
     * @throws FileNotFoundException if output filename is not legal
     */

    public static void main(String[] args) throws IOException {

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

        Properties props = new Properties();
        props.load(new FileReader(("config/config.props")));
        String pack = props.getProperty("operation_package");
        String operation_string = props.getProperty("operations");
        String[] operations = operation_string.split(",");
        List<String> operationPaths = new ArrayList<>();
        for (String operation : operations) {
            operationPaths.add(pack + "." + operation);
        }

        OperationManager om = new OperationManager(operationPaths);
        om.init();
        Calculator calculator = new ModernCalculator(om);
        OperationProcessor processor = new OperationProcessor(calculator);
        List<String> outputContentSecond = processor.processStrings(content);

        fo.listToFile(outputContentSecond, outfile);
    }
}


