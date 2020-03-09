package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class LogEntryService {

    private List<LogEntry> logEntry;
    private Map<String, Long> qty;
    private Map<String, Integer> qtyUser;


    public LogEntryService(List<LogEntry> logEntry) {
        this.logEntry = logEntry;
        qty = new HashMap<>();
        qtyUser = new HashMap<>();
    }

    public Map<String, Long> timesByUrl() {
        return qty = logEntry.stream().collect(groupingBy(LogEntry::getUrl, counting()));
    }

    public Map<String, Integer> usersByUrl() {
        return qtyUser = logEntry.stream()
                .collect(groupingBy(LogEntry::getUrl, mapping(LogEntry::getUserName, new DistinctCountingCollector<>())));
    }
}
