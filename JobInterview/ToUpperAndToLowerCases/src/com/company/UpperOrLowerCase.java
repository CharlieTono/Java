package com.company;

public class UpperOrLowerCase {

    public String replaceCases (String text) {

        StringBuilder finalWord = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char temp = text.charAt(i);
            if(temp >= 65 && temp <= 90) { //Upper to Lower
                finalWord.append(Character.toString(temp).toLowerCase());
            } else if (temp >= 97 && temp <= 122) { //Lower to Upper
                finalWord.append(Character.toString(temp).toUpperCase());
            } else {
                finalWord.append(temp);
            }
        }

        String result = finalWord.toString();

        return result;
    }
}
