package com.company;

import com.company.collection.List;
import com.company.collection.OurArrayList;
import com.company.comparator.CountryCodeComparator;
import com.company.comparator.OurComparator;

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
