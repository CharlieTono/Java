package com.company;

import com.company.collection.List;
import com.company.collection.NN;
import com.company.collection.OurArrayList;


public class Application {

    public static void main(String[] args) {
        NN hh1 = new NN("Test");
        NN hh2 = new NN("Test");
        NN hh3 = new NN("Test");

        List list = new OurArrayList();
        list.append(hh1);
        list.append(hh1);
        list.append(hh2);
        list.append(hh3);
        list.append(hh1);
        list.append(hh3);



    }
}
