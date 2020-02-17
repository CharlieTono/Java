package com.company;

public class Application {

    private static final int QTY_LOANS = 20;
    private static final int MIN_TIME = 100;
    private static final int MAX_TIME = 150;

    public static void main(String[] args) throws InterruptedException {

        Employee mary = new UsualEmployee("Mary", QTY_LOANS, (int) (MIN_TIME / 1.2), (int) (MAX_TIME / 1.2));
        Employee petr = new UsualEmployee("Petr", QTY_LOANS, MIN_TIME, MAX_TIME);
        Employee vasily = new UnusualEmployee("Vasily", QTY_LOANS, MIN_TIME, MAX_TIME, 1.5);

        Employee[] department = {mary, petr, vasily};

        Thread th01 = new Thread(mary);
        Thread th02 = new Thread(petr);
        Thread th03 = new Thread(vasily);

        long startTime = System.currentTimeMillis();
        th01.start();
        th02.start();
        th03.start();

        th01.join();
        th02.join();
        th03.join();

        for (int i = 0; i < department.length; i++) {
            System.out.println("Employee " + department[i].getName() + " issued all the credit in following time: " + (department[i].getFinishTime() - startTime));
        }
    }
}

