package com.company;

import com.company.calculator.Calculator;
import com.company.calculator.WrongOperandException;

import java.util.ArrayList;
import java.util.List;

public class OperationProcessor {

    private static final String WRONG_OPERAND = "The operand is not supported";
    private static final String WRONG_NUMBER_TYPE = "Incorrect number type";

    private Calculator calculator;

    public OperationProcessor(Calculator calculator) {
        this.calculator = calculator;
    }

    private static String DELIMITER = ",";

    public List<String> processStrings(List<String> lines) {

        List<String> result = new ArrayList<>();

        for (String line : lines) {
            result.add(processString(line));
        }
        return result;
    }

    protected String processString(String line) {
        try {
            String[] members = line.split(DELIMITER);
            double result = 0;
            double num1 = Double.parseDouble(members[0]);
            double num2 = Double.parseDouble(members[2]);
            char operand = members[1].charAt(0);
            result = calculator.calculate(num1, num2, operand);
            return line + DELIMITER + result;
        } catch (WrongOperandException e) {
            return WRONG_OPERAND;
        } catch (NumberFormatException e) {
            return WRONG_NUMBER_TYPE;
        }
    }
}
