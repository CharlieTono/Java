package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class UpperOrLowerCaseTest {

    UpperOrLowerCase cases = new UpperOrLowerCase();

    @Test
    public void testReplace_OnlyUpperCases_LowerCases() {
        String word = new String ("HELLO");
        assertEquals("hello", cases.replaceCases(word));
    }

    @Test
    public void testReplace_OnlyLowerCases_UpperCases() {
        String word = new String ("hello");
        assertEquals("HELLO", cases.replaceCases(word));
    }

    @Test
    public void testReplace_UpperAndLowerCases_SwitchCases() {
        String word = new String ("Hello");
        assertEquals("hELLO", cases.replaceCases(word));
    }

    @Test
    public void testReplace_UpperAndLowerCasesWithOtherSymbols_SwitchCases() {
        String word = new String ("Hello, You!");
        assertEquals("hELLO, yOU!", cases.replaceCases(word));
    }

}