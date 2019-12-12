package com.company.comparator;

import com.company.CountryCode;

public class CountryCodeComparator implements OurComparator {

    IntComparator intComparator = new IntComparator();

    @Override
    public int compare(Object o1, Object o2) {

        CountryCode code1 = (CountryCode) o1;
        CountryCode code2 = (CountryCode) o2;

        return intComparator.compare(code1.getCode(), code2.getCode());
    }
}
