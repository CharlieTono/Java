package com.company;

import java.util.*;

public class Book {

    List<String> book;

    public Book(List<String> book) {
        this.book = book;
    }

    public boolean isBookContain(String text) {
        int startIndex = 0;
        Deque<String> currentSplit = new ArrayDeque<>();
        return isBookContainRecursive(currentSplit, text, startIndex);
    }

    private boolean isBookContainRecursive(Deque<String> currentSplit, String text, int index) {
//
//        if (text.length() == 0 && index == book.size()) {
//            return true;
//        } else if (text.length() != 0 && index == book.size()) {
//            String oldText = currentSplit.removeLast();
//            oldText = oldText+text;
//            return isBookContainRecursive(currentSplit, oldText, index - 1);
//        }
//
//        for (int i = 0; i < text.length(); i++) {
//            String newText = text.substring(0, i + 1);
//            if (book.get(index).equals(newText) || book.get(index).equals(text)) {
//                currentSplit.addLast(newText);
//                newText = text.substring(i + 1);
//                return isBookContainRecursive(currentSplit, newText, index + 1);
//            }
//        }
//        return false;

        if (text.length() == 0 && index == book.size()) {
            return true;
        } else if (text.length() != 0 && index == book.size()) {
            String oldText = currentSplit.removeLast();
           oldText = oldText+text;
            return isBookContainRecursive(currentSplit, oldText, index - 1);
        } else if (book.get(index).equals(text)) {
            currentSplit.addLast(text);
            index++;
            return true;
        }

        for (int i = 0; i < text.length(); i++) {
//            if (book.get(index).equals(text)) {
//                currentSplit.addLast(text);
//                index++;
//                return true;
//            }
            String newText = text.substring(0, i + 1);
            if (book.get(index).equals(newText)) {
                currentSplit.addLast(newText);
                newText = text.substring(i + 1);
                return isBookContainRecursive(currentSplit, newText, index + 1);
            }
        }
        return false;

    }
}
