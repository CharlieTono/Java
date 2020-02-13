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

    public boolean patternCycle(String text, String pattern) {

        int length = text.length();

        if (length == 1) {
            return true;
        }

        if (text.length() < pattern.length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (pattern.charAt(pattern.length() - i - 1) == text.charAt(text.length() - i - 1)) {
                text = text.substring(i, text.length() - i - 1);
                pattern = pattern.substring(i, text.length() - i - 1);
                return patternCycle(text, pattern);
            } else {
                text = text.substring(i, text.length() - i - 1);
                return patternCycle(text, pattern);
            }
        }
        return false;
    }
}
