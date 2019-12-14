package com.company;

public class Censor {

    private String[] vocabulary;

    public Censor(String[] vocabulary) {
        this.vocabulary = vocabulary;
    }

    public boolean isLegal(String text) {

        for (int i = 0; i < vocabulary.length; i++) {

            if (vocabulary[i].equalsIgnoreCase(text)) {
                return false;
            }

        }
        return true;
    }
}
