package com.company;

public class Palindrome {

    public boolean checkPalindromeFirst(String text) {

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

    public boolean checkPalindromeSecond(String text) {

        String str = text.toLowerCase();
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
