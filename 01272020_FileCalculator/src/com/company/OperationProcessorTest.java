package com.company;

import com.company.calculator.Calculator;
import com.company.calculator.WrongOperandException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OperationProcessorTest {

    Calculator calculator;
    OperationProcessor op;

    @Before
    public void init() {
        calculator = mock(Calculator.class); //mock - objects without any functionality inside them (empty object)
        op = new OperationProcessor(calculator);
    }

    @Test
    public void testProcessString_legalLine_returnMultiplication() throws WrongOperandException {
        String line = "2.5,*,2";
        when(calculator.calculate(2.5, 2, '*')).thenReturn(5.0);
        String expected = line + ",5.0";
        assertEquals(expected, op.processString(line));
    }

    @Test
    public void testProcessString_illegalLineWrongOperation_returnThrowsWrongOperandException() throws WrongOperandException {
        String line = "2.5,*,2";
        when(calculator.calculate(2.5, 2, '*')).thenThrow(WrongOperandException.class);
        String expected = OperationProcessor.WRONG_OPERAND;
        assertEquals(expected, op.processString(line));
    }

    @Test
    public void testProcessString_illegalLineWrongTypeNumber_returnWrongNumberType() {
        String line = "a,*,2";
        String expected = OperationProcessor.WRONG_NUMBER_TYPE;
        assertEquals(expected, op.processString(line));
    }

}