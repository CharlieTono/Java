package com.company;

import com.company.collection.OurArrayList;
import com.company.collection.OurArrayListIterator;

import java.util.Iterator;

public class Application {

    public static void main(String... args) {

        OurArrayList<Integer> ints = new OurArrayList<>();
        ints.append(54);
        ints.append(1);
        ints.append(4);
        ints.append(5);

        //Iterator <Integer> iterator = new OurArrayListIterator<>(ints);
        Iterator<Integer> iterator = ints.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // the same with for each

        for (Integer num : ints) {
            System.out.println(num);
        }
    }
}
