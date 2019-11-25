package com.company;

public class Application {

    public static void main(String[] args) {

        LoanConsumer person01 = new LoanConsumer("Oleg", 60, 80000);
        LoanConsumer person02 = new LoanConsumer("Vlad", 29, 36000);
        LoanConsumer person03 = new LoanConsumer("Mark", 21, 8000);

        LoanIssuer consultant01 = new LoanIssuer("Mary", false, true);
        LoanIssuer consultant02 = new LoanIssuer("Petr", false, false);
        LoanIssuer consultant03 = new LoanIssuer("Vasily", true, true);

        System.out.println(consultant01.toIssue(person01));
        System.out.println(consultant02.toIssue(person02));
        System.out.println(consultant03.toIssue(person03));

        System.out.println(consultant01.toIssue(person03));
        System.out.println(consultant02.toIssue(person01));
        System.out.println(consultant03.toIssue(person02));

    }
}
