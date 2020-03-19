package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

public class Application {

    public static void main(String[] args) {

        String text = "({H}){[]";
        Deque<Character> brackets = new ArrayDeque<>();
        System.out.println(checkBracket(brackets, text));
    }

    public static int checkBracket(Deque<Character> myQueue, String text) {

        char[] newArray = text.toCharArray();
        int indexError = -1; // in case of non error
        myQueue.addLast('N'); // in case to avoid NoSuchElementException
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] == '(' || newArray[i] == '{' || newArray[i] == '[') {
                myQueue.addLast(newArray[i]);
                indexError = 1; // in case of error
            } else if (newArray[i] == ')' || newArray[i] == '}' || newArray[i] == ']') {
                if (newArray[i] == ')' && myQueue.getLast() == '(') {
                    myQueue.removeLast();
                    indexError = -1;
                } else if (newArray[i] == '}' && myQueue.getLast() == '{') {
                    myQueue.removeLast();
                    indexError = -1;
                } else if (newArray[i] == ']' && myQueue.getLast() == '[') {
                    myQueue.removeLast();
                    indexError = -1;
                } else {
                    indexError = 1;
                    return indexError;
                }
            }
        }
        if (myQueue.size() != 1) { // in case if some open bracket stays in the queue
            indexError = 1;
        }
        return indexError;
    }
}
