package data;

import StateConstants.StateConstants;
import org.w3c.dom.ls.LSOutput;

import java.util.Objects;

public class SalesManager extends Employee {

    private double salesValue;
    private double percent;

    public SalesManager(int ID, String firstName, String lastName, double hour, double salesValue, double percent) {
        super(ID, firstName, lastName, hour);
        this.salesValue = salesValue;
        this.percent = percent;
    }

    public double getSalesValue() {
        return salesValue;
    }

    public void setSalesValue(double salesValue) {
        this.salesValue = salesValue;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesManager)) return false;
        if (!super.equals(o)) return false;
        SalesManager that = (SalesManager) o;
        return Double.compare(that.salesValue, salesValue) == 0 &&
                Double.compare(that.percent, percent) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salesValue, percent);
    }

    @Override
    public String toString() {
        return super.toString()+ "\n" +
                "Sales Manager:" + "\n" +
                "value: " + salesValue + ", percent: " + percent + "\n";
    }

    @Override
    public double calculateSalary() {
        double salary = (salesValue*percent);
        if (salary <= StateConstants.MIN_WAGE*getHour()) {
            return getHour()*StateConstants.MIN_WAGE;
        }
        return salary;
    }
}
