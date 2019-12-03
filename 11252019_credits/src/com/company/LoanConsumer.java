package com.company;

public class LoanConsumer {
    private String name;
    private int age;
    private int salary;

    public LoanConsumer(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }
}
