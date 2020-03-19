package com.company;

public class Cycle {

    public boolean wheelCycle(String text01, String text02) {

        if (text01.length() != text02.length()) {
            return false;
        } else {
            for (int i = 1; i < text02.length(); i++) {
                String newText = text01.substring(i) + text01.substring(0, i);
                if (newText.equals(text02)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSubsequence(String text, String pattern) {

        return isSubsequenceRecursive(text, pattern, text.length(), pattern.length());
    }

    private boolean isSubsequenceRecursive(String text, String pattern, int textLength, int patternLength) {

        if (patternLength == 0 ) {
            return true;
        }

        if (textLength < patternLength) {
            return false;
        }

        if (pattern.charAt(patternLength-1) == text.charAt(textLength-1)) {
            return isSubsequenceRecursive(text, pattern, textLength -1, patternLength -1);
        } else {
            return isSubsequenceRecursive(text, pattern, textLength -1, patternLength);
        }
    }
}
