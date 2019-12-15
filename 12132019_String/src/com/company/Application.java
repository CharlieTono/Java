package com.company;

public class Application {
    public static void main(String[] args) {
        String word = "worldworldworld";
        String newWord = stringReverse(word);
        System.out.println(newWord);
        String word2 = "orl";
        System.out.println(counter(word, word2));

    }

    public static String stringReverse(String str) {

        char[] newArray = str.toCharArray();
        char temp;
        for (int i = 0; i < newArray.length / 2; i++) {
            temp = newArray[i];
            newArray[i] = newArray[newArray.length - 1 - i];
            newArray[newArray.length - 1 - i] = temp;
        }

        String newWord = new String(newArray);
        return newWord;
    }

    public static int counter(String str, String str2) {

        int i = 0;
        int counter = 0;

        while (i >= 0) {

            i = str.indexOf(str2, i);
            if (i > 0) {
                counter++;
                i = str.indexOf(str2, i + 1);
            }

        }
        return counter;
    }
}
