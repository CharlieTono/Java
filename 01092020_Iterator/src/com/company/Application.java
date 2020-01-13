package com.company;

import com.company.collection.OurArrayListIterator;
import com.company.collection.OurArrayListRandomIterator;
import com.company.collection.OurArrayOurList;
import com.company.collection.OurLinkedOurList;

import java.util.Iterator;

public class Application {

    public static void main(String... args) {

        OurArrayOurList<Integer> ints = new OurArrayOurList<>();
        ints.append(54);
        ints.append(1);
        ints.append(4);
        ints.append(5);

        //Iterator <Integer> iterator = new OurArrayListIterator<>(ints);
        Iterator<Integer> iterator = ints.iterator();

//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        // the same with for each

        for (Integer num : ints) {
            System.out.print(num + " ");
        }
        System.out.println();

        OurLinkedOurList<Integer> intsLinked = new OurLinkedOurList<>();
        intsLinked.append(54);
        intsLinked.append(1);
        intsLinked.append(4);
        intsLinked.append(5);

        Iterator<Integer> linkedIterator = intsLinked.iterator();
        Iterator<Iterator> randomIterator = new OurArrayListRandomIterator(ints);

        while (randomIterator.hasNext()){
            System.out.print(randomIterator.next() + " ");
        }
        System.out.println();

        for (Integer num : intsLinked) {
            System.out.print(num + " ") ;
        }
    }
}
