package com.company;

import java.util.Arrays;

public class Censor {

    private String[] vocabulary;

    public Censor(String[] vocabulary) {
        this.vocabulary = Arrays.copyOf(vocabulary, vocabulary.length);
    }

    public boolean isLegal(String text) {

        text = text.toLowerCase();

        for (int i = 0; i < vocabulary.length; i++) {
            if (text.contains(vocabulary[i].toLowerCase())) {
                return false;
            }
        }
        return true;
    }
}
