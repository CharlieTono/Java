package com.company;

public class Palindrome {

    public boolean checkPalindrome (String text) {

        text = text.replace(" ", "");

        StringBuilder palindromeReverse = new StringBuilder(text);
        palindromeReverse.reverse();
        String palindrome = palindromeReverse.toString();

        if (text.equalsIgnoreCase(palindrome)) {
            return true;
        } else {
            return false;
        }
    }
}
