package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        Map<Auto, String> carsToCharacteristic = fillCharacteristics();
        Auto che = new Auto("Chevrolet", "Cruze", "2015");
        System.out.println(carsToCharacteristic.get(che));

    }

    public static Map<Auto, String> fillCharacteristics() {
        Map<Auto, String> carsToCharacteristic = new HashMap<>();
        Auto chevrolet = new Auto("Chevrolet", "Cruze", "2015");
        Auto opel = new Auto("Opel", "Astra", "2016");
        Auto nissan = new Auto("Nissan", "X-Trail", "2017");

        carsToCharacteristic.put(chevrolet, "so so");
        carsToCharacteristic.put(opel, "wunderbar");
        carsToCharacteristic.put(nissan, "song");

        return carsToCharacteristic;
    }

}

class Auto {
    String label;
    String model;
    String issueDate;

    public Auto(String label, String model, String issueDate) {
        this.label = label;
        this.model = model;
        this.issueDate = issueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;
        Auto auto = (Auto) o;
        return Objects.equals(label, auto.label) &&
                Objects.equals(model, auto.model) &&
                Objects.equals(issueDate, auto.issueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, model, issueDate);
    }
}