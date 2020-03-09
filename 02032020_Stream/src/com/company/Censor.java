package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Censor {

    private Set<String> dictionary;

    public Censor(Collection<String> dictionary) {
        this.dictionary = dictionary.stream().map(String::toLowerCase).collect(Collectors.toSet());
    }

    public List<String> findBadWords(String text) {
        String[] words = text.split(" ");
        return Arrays.stream(words)
                .map(String::toLowerCase) // converts all letters to lower case
                .filter(dictionary::contains) //finds words from dictionary
                .distinct() // deletes the same words
                .sorted() // sorts words from a to z
                .collect(Collectors.toList()); // collects words into List
    }
}
