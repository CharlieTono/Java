package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        LogEntry log01 = new LogEntry("AA", "11");
        LogEntry log02 = new LogEntry("BB", "11");
        LogEntry log03 = new LogEntry("CC", "22");
        LogEntry log04 = new LogEntry("CC", "22");
        LogEntry log05 = new LogEntry("AA", "22");
        LogEntry log06 = new LogEntry("BB", "22");
        LogEntry log07 = new LogEntry("CC", "11");

        List<LogEntry> visitors = Arrays.asList(log01, log02, log03, log04, log05, log06, log07);
        LogEntryService logEntryService = new LogEntryService(visitors);
        System.out.println(logEntryService.timesByUrl().toString());
        System.out.println(logEntryService.usersByUrl().toString());

    }
}
