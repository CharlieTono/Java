package com.company;

public class CountryCode {

    String countryName;
    int code;

    public CountryCode(String countryName, int code) {
        this.countryName = countryName;
        this.code = code;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Country: " + countryName + ", " + code;
    }
}
