package com.company;

import java.util.ArrayList;
import java.util.List;

public class Book {

    List<String> book;

    public Book(List<String> book) {
        this.book = book;
    }

    public boolean isBookContain(String text) {
        int startIndex = 0;
        int counter = 0;
        List<String> currentSplit = new ArrayList<>();
        return isBookContainRecursive(currentSplit, text, startIndex, counter);
    }

    private boolean isBookContainRecursive(List<String> currentSplit, String text, int index, int counter) {

        if (counter == book.size()) {
            return true;
        }
        String newText = text.substring(index, index + 1);

        for (int i = 0; i < book.size(); i++) {
            if (!book.get(counter).equals(newText)) {
                newText = newText + text.charAt(index + 1);
                index++;
            } else {
                currentSplit.add(newText);
                return isBookContainRecursive(currentSplit, text, index + 1, counter + 1);
            }
        }
        return false;
    }
}
