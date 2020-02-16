package com.company;

public class FinishInfo {

    private String name;
    private long finishTime;

    public FinishInfo(String name, long finishTime) {
        this.name = name;
        this.finishTime = finishTime;
    }

    @Override
    public String toString() {
        return "Results of the finance department:" + "\n" +
                name + ": time - " + finishTime + "\n";
    }
}
