package data;

import StateConstants.StateConstants;

public class WageEmployee extends Employee{

    private double wage;

    public WageEmployee(int ID, String firstName, String lastName, double hour, double wage) {
        super(ID, firstName, lastName, hour);
        this.wage = wage;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return super.toString()+ "\n"+
                "Wage employee:" + "\n" +
                "wage: " + wage + "\n";
    }

    @Override
    public double calculateSalary() {
        double salary = wage*getHour();
        if (salary <= getHour()*StateConstants.MIN_WAGE) {
            return getHour()*StateConstants.MIN_WAGE;
        }
        return salary;
    }
}
