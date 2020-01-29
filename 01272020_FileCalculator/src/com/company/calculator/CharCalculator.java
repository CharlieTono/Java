package com.company.calculator;

import java.lang.reflect.InvocationTargetException;

public class CharCalculator implements Calculator {

    private static final String PATH_TO_OPERATION = "com.company.calculator.char_operations.";

    @Override
    public double calculate(double num1, double num2, char operand) throws WrongOperandException { // create an instance of Operation based on the operand
        String pathToClass = PATH_TO_OPERATION + getClassName(operand);
        try {
            Operation operation = (Operation) Class.forName(pathToClass).getDeclaredConstructor().newInstance();
            return operation.apply(num1, num2);
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            throw new WrongOperandException();
        }
    }

    private String getClassName(char operand) {

        String result = "Operation_" + (int) operand;

        return result;
    }
}
