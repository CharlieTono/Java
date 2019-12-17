package com.company.performance_tester;

import com.company.collection.List;
import com.company.collection.OurArrayList;

public class ArrayPerformanceTester extends PerformanceTester {
    @Override
    protected List getEmptyList() {
        return new OurArrayList();
    }

    @Override
    protected List makeList(int lengthList) {
        OurArrayList list = new OurArrayList();
        for (int i = 0; i < lengthList; i++) {
            list.append(o);
        }
        return list;
    }
}
