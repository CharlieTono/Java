package com.company;

public class Application {

    public static void main(String[] args) {

        String[] group01 = {"Pluto is a planet", "The Earth is plane"};
        String[] group02 = {"Homeopathy", "Extrasensory"};
        String[] group03 = {"Astrology", "Horoscope"};

        Censor person01 = new Censor(group01);
        Censor person02 = new Censor(group02);
        Censor person03 = new Censor(group03);

    }
}
