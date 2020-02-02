package com.company.calculator.modern_operations;

import com.company.calculator.ModernOperations;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperationMultiplicationTest {

    private ModernOperations operation = new OperationMultiplication();

    @Test
    public void testApply_ZeroAndNonZero_Result() {
        assertEquals(0, operation.apply(0, 2.5), 0.00001);
    }

    @Test
    public void testApply_NonZeroAndZero_Result() {
        assertEquals(2, operation.apply(-2, -1), 0.00001);
    }

    @Test
    public void testApply_NonZeroAndNonZero_Result() {
        assertEquals(10, operation.apply(5, 2), 0.00001);
    }


}