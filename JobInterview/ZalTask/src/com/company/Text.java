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

    public Text(){}

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

    /**
     * crop the text so that it contains no more than k symbols.
     * If the last symbols in the end don`t compose a word, than remove them up to the prev word.
     *
     * @param text String to crop
     * @param k    the text length limit
     * @return cropped text according to the rule
     */

    public String crop(String text, int k) {
        int length = text.length();
        if (length <= k) {
            return text;
        }

        String res = text.substring(0, k + 1);
        int lastSpaceIndex = res.lastIndexOf(" ");
        res = lastSpaceIndex < 0 ? "" : res.substring(0, lastSpaceIndex);
        return res;
    }

}
