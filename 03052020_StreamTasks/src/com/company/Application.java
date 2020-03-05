package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {

        Transaction tr01 = new Transaction(State.CANCELED, 10000);
        Transaction tr02 = new Transaction(State.PROCESSING, 10000);
        Transaction tr03 = new Transaction(State.PROCESSING, 10000);
        Transaction tr04 = new Transaction(State.CANCELED, 10000);
        Transaction tr05 = new Transaction(State.FINISHED, 10000);
        Transaction tr06 = new Transaction(State.FINISHED, 10000);
        Transaction tr07 = new Transaction(State.CANCELED, 10000);
        Transaction tr08 = new Transaction(State.FINISHED, 10000);
        Transaction tr09 = new Transaction(State.PROCESSING, 10000);

        Account acc01 = new Account(500, Arrays.asList(tr01, tr02, tr03));
        Account acc02 = new Account(-500, Arrays.asList(tr04, tr05, tr06));
        Account acc03 = new Account(1, Arrays.asList(tr07, tr08, tr09));

        Stream<Account> accountStream = Stream.of(acc01, acc02, acc03);

        long res = accountStream.filter(acc -> acc.getBalance() > 0)
                .flatMap(account -> account.getTransactions().stream())
                .filter(transaction -> transaction.getState() == State.CANCELED)
                .mapToLong(Transaction::getSum)
                .sum();

        System.out.println(res);

//        long res02 = accountStream.filter(acc -> acc.getBalance() > 0)
//                .flatMap(account -> account.getTransactions().stream())
//                .filter(transaction -> transaction.getState() == State.CANCELED)
//                .collect(Collectors.reducing(0L, Transaction::getSum, (currentResult, currentElt) -> currentElt + currentResult));
//
//        System.out.println(res02);

        Employee per01 = new Employee("Alex", 2000);
        Employee per02 = new Employee("Bob", 3000);
        Employee per03 = new Employee("Carl", 4000);
        Employee per04 = new Employee("David", 5000);
        Employee per05 = new Employee("Emma", 6000);

        List<Employee> col01 = Arrays.asList(per01, per02);
        List<Employee> col02 = Arrays.asList(per03, per04);
        List<Employee> col03 = Arrays.asList(per05);

        Department dep01 = new Department("Logistic", "111-222", col01);
        Department dep02 = new Department("Sales", "111-333", col02);
        Department dep03 = new Department("Management", "222-111", col03);

        Stream<Department> companyStream = Stream.of(dep01, dep02, dep03);

        long qtyOfEmployees = companyStream.filter(dep -> dep.getCode().startsWith("111"))
                .flatMap(dep -> dep.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= 3000)
                .count();
        System.out.println(qtyOfEmployees);

    }
}
