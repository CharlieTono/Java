package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {

    Palindrome palindrome = new Palindrome();

    @Test
    public void testCheckPalindrome_NonPalindrome_False() {
        String text = new String ("Hello");
        assertFalse(palindrome.checkPalindrome(text));
    }

    @Test
    public void testCheckPalindrome_PalindromeOneWord_true() {
        String text = new String ("Anna");
        assertTrue(palindrome.checkPalindrome(text));
    }

    @Test
    public void testCheckPalindrome_PalindromePhrase_true() {
        String text = new String ("Kirill lirik");
        assertTrue(palindrome.checkPalindrome(text));
    }

}