package com.company;

public class HandlerInfo {

    private String host;
    private int port;

    public HandlerInfo(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public HandlerInfo() {
    }

    public synchronized String getHost() {
        return host;
    }

    public synchronized int getPort() {
        return port;
    }

    public synchronized void setHost(String host) {
        this.host = host;
    }

    public synchronized void setPort(int port) {
        this.port = port;
    }
}
