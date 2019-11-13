package data;

import java.util.Objects;

public abstract class Employee {

    private int ID;
    private String firstName;
    private String lastName;
    private double hour;

    public Employee(int ID, String firstName, String lastName, double hour) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hour = hour;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return ID == employee.ID &&
                Double.compare(employee.hour, hour) == 0 &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, hour);
    }

    @Override
    public String toString() {
        return "Employee: " + ID + "\n" +
                "Name " + firstName + " " + lastName + "\n" +
                "hour: " + hour;
    }

    public abstract double calculateSalary ();

    public double calculateTax () {
        double salary = this.calculateSalary();
        double tax = 0;

        int [] levels = {0, 6220, 8920, 14320, 19990, 41410, 53333};
        double [] rates = {0.1, 0.14, 0.2, 0.31, 0.35, 0.47, 0.5};

        for (int i =0 ; i < rates.length; i++) {
            if (salary>levels[i] && salary <= levels[i+1]) {
                return tax+((salary-levels[i]))*rates[i];
            } else {
                tax = tax + ((levels[i+1]-levels[i]))*rates[i];
            }
        }
        return tax + ((salary-levels[levels.length])*rates.length);
    }
}
