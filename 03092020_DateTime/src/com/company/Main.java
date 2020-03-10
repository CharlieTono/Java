package com.company;

import java.time.*;
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
        System.out.println(todayAndTomorrow);
        System.out.println(ChronoUnit.DAYS.between(today, tomorrow));

        System.out.println(today.getDayOfWeek());

        System.out.println("******");
        DateTimeFormatter euFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter usFormatter = DateTimeFormatter.ofPattern("MM.dd.yy");
        LocalDate bd = LocalDate.parse("22.11.1990", euFormatter);
        System.out.println(bd.getDayOfWeek());
        System.out.println(bd.getDayOfYear());
        System.out.println(bd.format(usFormatter));

        System.out.println("******");
        LocalTime now = LocalTime.now();
        System.out.println(now);
        LocalTime nextHour = now.plus(1, ChronoUnit.HOURS);
        LocalTime nextHour2 = now.plus(Duration.ofHours(1));
        System.out.println(nextHour);
        System.out.println(nextHour2);

        System.out.println("******");
        LocalTime begging = LocalTime.parse("10:00:00");
        LocalTime middleOfTheLesson = LocalTime.now();
        System.out.println(Duration.between(begging, middleOfTheLesson).getSeconds());
        System.out.println(ChronoUnit.SECONDS.between(begging, middleOfTheLesson));

        System.out.println("******");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("hh-mm-ss");
        LocalTime end = LocalTime.parse("11:03:30");
        while (end.isAfter(LocalTime.now())) {
            System.out.println(LocalTime.now().format(formatter1));
        }

        System.out.println("******");
        LocalDateTime dayStart = LocalDate.now().atStartOfDay();
        LocalDateTime dayStart2 = LocalDate.now().atTime(10, 0);
        LocalDateTime.parse("2020-03-10T11:00:00");

        System.out.println("******");
        ZonedDateTime zDate = ZonedDateTime.now();
        ZonedDateTime zDateMoscow = ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
        System.out.println(zDate);
        System.out.println(zDateMoscow);

        System.out.println("******");
        ZonedDateTime zDateMoscowWrong = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Moscow"));
        System.out.println(zDateMoscowWrong);
        ZoneId.getAvailableZoneIds().forEach(System.out::println);
        System.out.println(zDateMoscow.withZoneSameInstant(ZoneId.of("Australia/Sydney")));

        System.out.println("******");
        ZonedDateTime moscowTime = ZonedDateTime.of(LocalDate.now().atTime(8, 0), ZoneId.of("Europe/Moscow"));
        ZonedDateTime vladivostokTime = ZonedDateTime.of(LocalDate.now().atTime(18, 0), ZoneId.of("Asia/Vladivostok"));
        long result = ChronoUnit.HOURS.between(vladivostokTime, moscowTime);
        if (result < 0) {
            System.out.println("Winner is");
            System.out.println(moscowTime);
        } else {
            System.out.println("Winner is");
            System.out.println(vladivostokTime);
        }

        if (moscowTime.isBefore(vladivostokTime)) {
            System.out.println(moscowTime + " comes before " + vladivostokTime);
        } else {
            System.out.println(vladivostokTime + " comes before " + moscowTime);
        }

        System.out.println("**A**");
        ZonedDateTime spbTimeStart = ZonedDateTime.of(LocalDate.now().atTime(9, 0), ZoneId.of("Europe/Moscow"));
        ZonedDateTime spbTimeFinish = ZonedDateTime.of(LocalDate.now().atTime(18, 0), ZoneId.of("Europe/Moscow"));
        ZonedDateTime nyTimeStart = ZonedDateTime.of(LocalDate.now().atTime(8, 0), ZoneId.of("America/New_York"));
        ZonedDateTime nyTimeFinish = ZonedDateTime.of(LocalDate.now().atTime(17, 0), ZoneId.of("America/New_York"));

        int counter = 0;
        while (!spbTimeStart.equals(spbTimeFinish)) {
            ZonedDateTime nyComparingTime = spbTimeStart.withZoneSameInstant(ZoneId.of("America/New_York"));
            spbTimeStart = spbTimeStart.plusHours(1);
            if (nyComparingTime.isEqual(nyTimeStart) || nyComparingTime.isAfter(nyTimeStart) && nyComparingTime.isBefore(nyTimeFinish)) {
                counter++;
            }
        }
        System.out.println("Total qty of hours for meeting time for colleagues from NY and Moscow is " + counter);

        System.out.println("**B**");
        ZonedDateTime londonTimeStart = ZonedDateTime.of(LocalDate.now().atTime(8, 30), ZoneId.of("Europe/London"));
        ZonedDateTime londonTimeFinish = ZonedDateTime.of(LocalDate.now().atTime(17, 0), ZoneId.of("Europe/London"));

        int counters = 0;
        while (!londonTimeStart.equals(londonTimeFinish)) {
            ZonedDateTime nyComparingTime = londonTimeStart.withZoneSameInstant(ZoneId.of("America/New_York"));
            londonTimeStart = londonTimeStart.plusMinutes(30);
            if (nyComparingTime.isEqual(nyTimeStart) || nyComparingTime.isAfter(nyTimeStart) && nyComparingTime.isBefore(nyTimeFinish)) {
                counters++;
            }
        }
        System.out.println("Total qty of hours for meeting time for colleagues from NY and London is " + counters/2);
    }
}
