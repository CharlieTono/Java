package com.company.calculator.modern_operations;

import com.company.calculator.ModernOperations;

public class OperationMultiplication implements ModernOperations {

    @Override
    public char getSymbol() {
        return '*';
    }

    @Override
    public double apply(double num1, double num2) {
        return num1 * num2;
    }
}
