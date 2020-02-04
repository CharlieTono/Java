package com.company;

import java.util.Comparator;

public class Application {

    public static void main(String[] args) {

        OurStack<Auto> autos = new OurStack<>(new DataComparator());

        Auto citroen = new Auto("Citroen", "C4", 2010);
        Auto opel = new Auto("Opel", "Astra", 2012);
        Auto nissan = new Auto("Nissan", "X-Trail", 2018);

        autos.addLast(citroen);
        autos.addLast(opel);
        autos.addLast(nissan);

    }
}

class Auto implements Comparable<Auto> {
    String brand;
    String model;
    int date;

    public Auto(String brand, String model, int date) {
        this.brand = brand;
        this.model = model;
        this.date = date;
    }

    @Override
    public int compareTo(Auto o) {

        if (brand.compareTo(o.brand) < 0)
            return -1;
        else if (brand.compareTo(o.brand) > 0)
            return 1;
        if (model.compareTo(o.model) < 0)
            return -1;
        else if (model.compareTo(o.model) > 0)
            return 1;
        if (brand.compareTo(o.brand) < 0)
            return -1;
        else
            return date - o.date;

    }
}

class BrandLexicographicalComparator implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {
        return o1.brand.compareTo(o2.brand);
    }
}

class DataComparator implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {
        return o1.date - o2.date;  // Integer.compare(o1.date, o2.date);
    }
}
