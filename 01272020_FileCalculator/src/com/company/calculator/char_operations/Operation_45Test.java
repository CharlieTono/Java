package com.company.calculator.char_operations;

import com.company.calculator.Operation;
import org.junit.Test;

import static org.junit.Assert.*;

public class Operation_45Test {

    private Operation operation = new Operation_45();

    @Test
    public void testApply_ZeroAndNonZero_Result() {
        assertEquals(-2.5, operation.apply(0, 2.5), 0.00001);
    }

    @Test
    public void testApply_NonZeroAndZero_Result() {
        assertEquals(2.5, operation.apply(2.5, 0), 0.00001);
    }

    @Test
    public void testApply_NonZeroAndNonZero_Result() {
        assertEquals(1, operation.apply(3.5, 2.5), 0.00001);
    }

}