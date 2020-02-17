package com.company;

public class UsualEmployee extends Employee {

    public UsualEmployee(String name, int loan, int min, int max) {
        super(name, loan, min, max);
    }

    @Override
    public void run() {

        for (int i = 0; i < loan; i++) {
            int toSleep = min + random.nextInt(max - min);
            try {
                Thread.sleep(toSleep);
            } catch (InterruptedException e) {
                return;
            }
        }
        finishTime = System.currentTimeMillis();
    }
}
