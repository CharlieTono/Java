package com.company;

public class Application {

    public static void main(String[] args) {

        LoanConsumer person01 = new LoanConsumer("Oleg", 60, 80000);
        LoanConsumer person02 = new LoanConsumer("Vlad", 29, 36000);
        LoanConsumer person03 = new LoanConsumer("Mark", 21, 8000);
        LoanConsumer person04 = new LoanConsumer("Olga", 30, 15000);
        LoanConsumer person05 = new LoanConsumer("Elena", 40, 55000);
        LoanConsumer person06 = new LoanConsumer("Irina", 70, 40000);

        LoanIssuer consultant01 = new LoanIssuer("Mary", false, true);
        LoanIssuer consultant02 = new LoanIssuer("Petr", false, false);
        LoanIssuer consultant03 = new LoanIssuer("Vasily", true, true);

        LoanIssuer [] workers = {consultant01, consultant02, consultant03};
        LoanConsumer [] consumers = {person01, person02, person03, person04, person05, person06};

        printResult(consumers, workers);

    }

    public static void printResult (LoanConsumer [] consumers, LoanIssuer [] workers) {

        for (LoanIssuer i: workers) {
            for (LoanConsumer j: consumers) {
                if (i.toIssue(j)) {
                    System.out.println(i.getName() + " issued a loan to " + j.getName());
                } else {
                    System.out.println(i.getName() + " did not issue a loan to " + j.getName());
                }
            }
        }

        /*
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < consumers.length; j++) {
                if (workers[i].toIssue(consumers[j])) {
                    System.out.println(workers[i].getName() + " issued a loan to " + consumers[j].getName());
                } else {
                    System.out.println(workers[i].getName() + " did not issue a loan to " + consumers[j].getName());
                }
            }
        }
        */
    }
}
