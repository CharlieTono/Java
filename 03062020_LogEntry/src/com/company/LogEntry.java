package com.company;

public class LogEntry {

    private String userName;
    private String url;

    public LogEntry(String userName, String url) {
        this.userName = userName;
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public String getUrl() {
        return url;
    }
}
