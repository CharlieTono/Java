package controller;

import dao.Company;
import data.SalesManager;
import data.WageEmployee;

import java.util.Arrays;

public class companyApp {
    public static void main(String[] args) {

        SalesManager sm01 = new SalesManager(1234, "Sam", "Smith", 20, 500000, 0.1);
        SalesManager sm02 = new SalesManager(1342, "Mark", "Milan", 50, 600000, 0.1);
        WageEmployee we01 = new WageEmployee(5678, "Bob", "Brown", 40, 10);
        WageEmployee we02 = new WageEmployee(5768, "Oscar", "Oldman", 35, 20);

        Company companyX = new Company(20);
        companyX.addEmployee(sm01);
        companyX.addEmployee(we01);
        companyX.addEmployee(sm02);
        companyX.addEmployee(we02);

        System.out.println(sm01.calculateSalary());
        System.out.println(sm02.calculateSalary());
        System.out.println(we01.calculateSalary());
        System.out.println(we02.calculateSalary());

        System.out.println(companyX.findMinSalary());
        System.out.println(companyX.findMaxSalary());
        System.out.println(companyX.totalSumSalary());
        System.out.println(companyX.findPoorPerson());
        System.out.println("***");
        System.out.println(Arrays.toString(companyX.displayPoorPersons(3)));

    }
}
