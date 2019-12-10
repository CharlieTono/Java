package com.company.comparator;

public class IntComparator implements OurComparator {

    @Override
    public int compare(Object o1, Object o2) {

        Integer left = (Integer) o1;
        Integer right = (Integer) o2;

        if (left < right) {
            return -1;
        }
        if (left > right) {
            return 1;
        }
        return 0;
    }

    @Override
    public void sortOut(Object[] array) {
        Object temp = array[0];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (compare(array[j], array[j + 1]) > 0) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
