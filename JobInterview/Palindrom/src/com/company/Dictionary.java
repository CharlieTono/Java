package com.company;

import java.util.*;

public class Dictionary {

    Set<String> dictionary;

    public Dictionary(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * @param text to be split
     * @return a list of words which the text is split on,
     * or null, if the text can`t be split
     */

    public Deque<String> split(String text) {
        Deque<String> result = new ArrayDeque<>();

        return splitRecursive(text, 0, result) ? result : null;
    }

    private boolean splitRecursive(String text, int index, Deque<String> result) {

        if (index == text.length()) {
            return true;
        }

        for (String word : dictionary) {
            if (text.startsWith(word, index)) {
                result.addLast(word);
                boolean isSplit = splitRecursive(text, index + word.length(), result);
                if (isSplit) {
                    return true;
                } else {
                    result.removeLast();
                }
            }
        }

        return false;
    }
}
