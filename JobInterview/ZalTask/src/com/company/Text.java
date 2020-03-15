package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Text {

    private String text;
    private int number;

    public Text(String text, int number) {
        this.text = text;
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public int getNumber() {
        return number;
    }

    public String cutText() {
        String[] array = text.split(" ");
        List<String> newText = Arrays.stream(array).filter(word -> word.length() <= number).collect(Collectors.toList());
        String result = newText.get(0);
        int i = 1;
        while (result.concat(newText.get(i)).concat(" ").length() <= number) {
            result = result.concat(" ".concat(newText.get(i)));
            i++;
        }
        return result;
    }
}
