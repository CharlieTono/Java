package com.company;

import com.company.collection.List;
import com.company.collection.OurArrayList;
import com.company.comparator.CountryCodeComparator;
import com.company.comparator.OurComparator;
import com.company.performance_tester.ArrayPerformanceTester;
import com.company.performance_tester.LinkedListPerformanceTester;
import com.company.performance_tester.PerformanceTester;

public class Application {

    public static void main(String[] args) {

        CountryCode usa = new CountryCode("USA", 1);
        CountryCode russia = new CountryCode("Russia", 7);
        CountryCode germany = new CountryCode("Germany", 49);
        CountryCode israel = new CountryCode("Israel", 972);
        OurComparator countryCodesComparator = new CountryCodeComparator();
        List countryCodes = new OurArrayList();
        fillCountryCodes(countryCodes);
        System.out.println(countryCodes.max(countryCodesComparator));
        System.out.println(countryCodes.min(countryCodesComparator));
        countryCodes.sort(countryCodesComparator);
        for (int i = 0; i < countryCodes.size(); i++) {
            System.out.println(countryCodes.get(i));
        }

        PerformanceTester arrayTester = new ArrayPerformanceTester();
        PerformanceTester linkedArrayTester = new LinkedListPerformanceTester();
        System.out.println(arrayTester.testAppend(100000));
        System.out.println(linkedArrayTester.testAppend(100000));
        System.out.println(arrayTester.testGet(10000,10000));
        System.out.println(linkedArrayTester.testGet(10000,10000));
        System.out.println(arrayTester.testRemoveFirst(10000,100000));
        System.out.println(linkedArrayTester.testRemoveFirst(10000,100000));

    }

    private static void fillCountryCodes(List countyCodes) {
        CountryCode usa = new CountryCode("USA", 1);
        CountryCode russia = new CountryCode("Russia", 7);
        CountryCode germany = new CountryCode("Germany", 49);
        CountryCode israel = new CountryCode("Israel", 972);

        countyCodes.append(germany);
        countyCodes.append(usa);
        countyCodes.append(israel);
        countyCodes.append(russia);

    }

}
