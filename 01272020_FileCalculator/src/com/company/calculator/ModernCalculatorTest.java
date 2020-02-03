package com.company.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ModernCalculatorTest {

    ModernCalculator modernCalculator;
    OperationManager om;
    Operation operation;

    @Before
    public void unit() {
        operation = mock(Operation.class);
        om = mock(OperationManager.class);
        modernCalculator = new ModernCalculator(om);
    }

    @Test
    public void testCalculate_legalOperation() throws WrongOperandException {
        when(om.get('+')).thenReturn(operation);
        when(operation.apply(4, 5)).thenReturn(9.);
        double expected = 9;
        assertEquals(expected, modernCalculator.calculate(4, 5, '+'), 0.0001);
    }

    @Test(expected = WrongOperandException.class)
    public void testCalculate_illegalOperation_throwsWrongOperandException() throws WrongOperandException {
        when(modernCalculator.calculate(2.5, 2, '-')).thenThrow(WrongOperandException.class);
    }
}