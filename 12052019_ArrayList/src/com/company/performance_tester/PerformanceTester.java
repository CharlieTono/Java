package com.company.performance_tester;

import com.company.collection.List;

import java.util.Random;

public abstract class PerformanceTester { //pattern template method

    protected Object o = new Object();

    public long testAppend (int n) {
        List list = getEmptyList();
        long now = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.append(0);
        }
        return System.currentTimeMillis() - now;
    }

    protected abstract List getEmptyList();

    public long testGet (int n, int lengthList) {
        List list = makeList(lengthList);
        long now = System.currentTimeMillis();

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            list.get(random.nextInt(lengthList));
        }
        return System.currentTimeMillis() - now;
    }

    protected abstract List makeList(int lengthList);


}
