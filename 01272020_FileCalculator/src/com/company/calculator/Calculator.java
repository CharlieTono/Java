package com.company.calculator;

public interface Calculator {

    /**
     *
     * @param num1 first number
     * @param num2 second number
     * @param operation operation to performe over the numbers
     * @return the result of the operation
     * @throws WrongOperandException in case if the operand is not supported
     */

    double calculate (double num1, double num2, char operation) throws WrongOperandException;
}
