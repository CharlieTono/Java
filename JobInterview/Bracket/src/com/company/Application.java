package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

public class Application {

    public static void main(String[] args) {

        String text = "({H})";
        Deque<Character> brackets = new ArrayDeque<>();
        System.out.println(checkBracket(brackets, text));
    }

    public static int checkBracket(Deque<Character> myQueue, String text) {

        char[] newArray = text.toCharArray();
        int indexResult = -1;
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] == '(' || newArray[i] == '{' || newArray[i] == '[') {
                myQueue.addLast(newArray[i]);
                indexResult = i;
            } else if (newArray[i] == ')' || newArray[i] == '}' || newArray[i] == ']') {
                indexResult = i;
                if (newArray[i] == ')' && myQueue.offerLast('{')) {
                    myQueue.removeLast();
                    indexResult = i - indexResult;
                } else if (newArray[i] == '}' && myQueue.offerLast('{')) {
                    myQueue.removeLast();
                } else if (newArray[i] == ']' && myQueue.offerLast('[')) {
                    myQueue.removeLast();
                }
            }
        }
        return indexResult;
    }
}
