package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
        System.out.println(today.format(formatter));

        LocalDate tomorrow = today.plus(Period.ofDays(1));
        System.out.println(tomorrow.format(formatter));

        LocalDate yesterday = today.minus(Period.ofDays(1));
        System.out.println(yesterday.format(formatter));

        Period todayAndTomorrow = Period.between(today, tomorrow);
        System.out.println(todayAndTomorrow.get(ChronoUnit.DAYS));

        System.out.println(today.getDayOfWeek());

        //BD
        DateTimeFormatter euFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter usFormatter = DateTimeFormatter.ofPattern("MM.dd.yy");
        LocalDate bd = LocalDate.parse("22.11.1990", euFormatter);
        System.out.println(bd.getDayOfWeek());
        System.out.println(bd.getDayOfYear());
        System.out.println(bd.format(usFormatter));

    }
}
