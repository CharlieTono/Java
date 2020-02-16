package com.company;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int QTY_LOANS = 20;
    private static final int MIN_TIME = 0;
    private static final int MAX_TIME = 100;

    public static void main(String[] args) throws InterruptedException {

        List<FinishInfo> winRate = new ArrayList<>();
        Employee mary = new PersonFirst("Mary", 20, 1, 10, winRate);
        Employee petr = new PersonSecond("Petr", 20, 1, 10, winRate);
        Employee vasily = new PersonThrid("Vasily", 20, 1, 10, winRate);

        List<Employee> department = new ArrayList<>();
        department.add(mary);
        department.add(petr);
        department.add(vasily);

        List<Thread> race = registeringEmployees(department);

        start(race);
        join(race);

        System.out.println(winRate.toString());

    }

    private static List<Thread> registeringEmployees(List<Employee> department) {
        List<Thread> res = new ArrayList<>();
        for (int i = 0; i < department.size(); i++) {
            Thread th = new Thread(department.get(i));
            res.add(th);
        }
        return res;
    }

    private static void start(List<Thread> department) {
        for (Thread thread : department) {
            thread.start();
        }
    }

    private static void join(List<Thread> department) throws InterruptedException {
        for (Thread thread : department) {
            thread.join();
        }
    }
}

