package com.company;

public class LoanIssuer {
    private String name;
    private boolean isLazy;
    private boolean isKind;

    public LoanIssuer(String name, boolean isLazy, boolean isKind) {
        this.name = name;
        this.isLazy = isLazy;
        this.isKind = isKind;
    }

    public boolean toIssue (LoanConsumer consumer) {

        if (this.isLazy) {
            if (consumer.getSalary() >= 20000) {
                return true;
            }
        } else if (this.isKind) {
            if (consumer.getSalary() >= 20000 && consumer.getAge() < 70) {
                return true;
            }
        } else {
            if (consumer.getSalary() >= 20000 && consumer.getAge() < 50) {
                return true;
            }
        }
        return false;
    }
}
