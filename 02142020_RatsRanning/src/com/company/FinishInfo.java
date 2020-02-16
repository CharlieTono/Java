package com.company;

public class FinishInfo {

    int RatId;
    long finishTime;

    public FinishInfo(int ratId, long finishTime) {
        RatId = ratId;
        this.finishTime = finishTime;
    }

    @Override
    public String toString() {
        return "Rat " + RatId + ", finishTime: " + finishTime;
    }
}
