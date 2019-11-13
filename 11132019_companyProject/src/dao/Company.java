package dao;

import data.Employee;

public class Company {

    private Employee[] employees;
    private int size;

    public Company(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size] = employee;
            size++;
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employees[i].equals(employee)) {
                employees[i] = employees[size - 1];
                size--;
                return true;
            }
        }
        return false;
    }

    public double findMinSalary () {
        double minSalary = employees[0].calculateSalary();
        for (int i = 1; i < size-1; i++) {
            if (minSalary > employees[i].calculateSalary()) {
                minSalary = employees[i].calculateSalary();
            }
        }
        return minSalary;
    }

    public double findMaxSalary () {
        double maxSalary = employees[0].calculateSalary();
        for (int i = 1; i < size-1; i++) {
            if (maxSalary < employees[i].calculateSalary()) {
                maxSalary = employees[i].calculateSalary();
            }
        }
        return maxSalary;
    }

    public double totalSumSalary () {
        double totalSum = 0;
        for (int i = 0; i < size; i++) {
            totalSum += employees[i].calculateSalary();
        }
        return totalSum;
    }

    public Employee findPoorPerson () {
        Employee poorPerson = employees [0];
        for (int i = 1; i < size; i++) {
            if (poorPerson.calculateSalary()>employees[i].calculateSalary()) {
                poorPerson = employees[i];
            }
        }
        return poorPerson;
    }

    public Employee [] displayPoorPersons (int numberOfPerson) {
        Employee[] poorPersons = new Employee[numberOfPerson];
        Employee poorPerson;

        for (int i = 0; i < size; i++) { // bubble sort
            for (int j = 0; j < size-i-1; j++) {
                if (employees[j].calculateSalary() > employees[j+1].calculateSalary()) {
                    poorPerson = employees[j];
                    employees[j] = employees[j+1];
                    employees[j+1] = poorPerson;
                }
            }
        }

        for (int i = 0; i < numberOfPerson; i++) {
            poorPersons[i] = employees[i];
        }
        return poorPersons;
    }
}
