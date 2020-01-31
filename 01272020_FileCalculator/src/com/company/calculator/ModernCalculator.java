package com.company.calculator;

public class ModernCalculator implements Calculator {

    OperationManager manager;

    public ModernCalculator(OperationManager manager) {
        this.manager = manager;
    }

    @Override
    public double calculate(double num1, double num2, char operation) throws WrongOperandException {

        Operation operand = manager.get(operation);

        if (operand == null) {
            throw new WrongOperandException();
        }

        return operand.apply(num1, num2);
    }
}
