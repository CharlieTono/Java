package com.company.performance_tester;

import com.company.collection.List;
import com.company.collection.OurLinkedList;

public class LinkedListPerformanceTester extends PerformanceTester {
    @Override
    protected List getEmptyList() {
        return new OurLinkedList();
    }

    @Override
    protected List makeList(int lengthList) {
        OurLinkedList list = new OurLinkedList();
        for (int i = 0; i < lengthList; i++) {
            list.append(o);
        }
        return list;
    }
}
