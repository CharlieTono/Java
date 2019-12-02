package com.company;

import java.util.Arrays;

public class SortedNumberList {

    private int[] source;

    public SortedNumberList() {
        this.source = new int[0];
    }

    public SortedNumberList(int[] array) {
        this.source = ArrayUtils.copyArray(array);
        ArrayUtils.selectionSort(source);
    }

    public void add(int value) {
        this.source = ArrayUtils.append(source, value);
        ArrayUtils.selectionSort(source);
    }

    public int get(int index) {
        return this.source[index];
    }

    public int size() {
        return this.source.length;
    }

    /**
     * remove element by index
     *
     * @param index of the element to remove
     * @return removed element
     */

    public int removeById(int index) { //to move to ArrayUtils as option

        int[] newArray = new int[source.length - 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = this.source[i];
        }

        for (int i = index + 1; i < source.length; i++) {
            newArray[i - 1] = source[i];
        }

        int result = this.source[index];
        this.source = newArray;

        return result;
    }

    public boolean remove(int value) {

        int number = ArrayUtils.binarySearch(source, value);

        if (number >= 0) {
            removeById(number);
            return true;
        }
        return false;
    }

    public void removeRepeated() {

        if (this.source.length == 0) {
            return;
        }

        int counter = 1;
        for (int i = 1; i < source.length; i++) {
            if (source[i] != source[i - 1]) {
                counter++;
            }
        }

        int[] newArray = new int[counter];
        newArray[0] = this.source[0];
        int index = 1;

        for (int i = 1; i < source.length; i++) {
            if (source[i] != source[i - 1]) {
                newArray[index] = source[i];
                index++;
            }
        }
        this.source = newArray;
    }

    public SortedNumberList intersection(SortedNumberList array) {

        SortedNumberList sortedNewArray = new SortedNumberList();

        for (int i = 0; i < array.size(); i++) {
            if (ArrayUtils.binarySearch(source, array.get(i)) >= 0) {
                sortedNewArray.add(array.get(i));
                sortedNewArray.add(array.get(i));
            }
        }
        return sortedNewArray;
    }

    public SortedNumberList union(SortedNumberList array) {

        int[] newArray = ArrayUtils.copyArray(source);
        SortedNumberList sortedNewArray = new SortedNumberList(newArray);

        for (int i = 0; i < array.size(); i++) {
            sortedNewArray.add(array.get(i));
        }
        sortedNewArray.removeRepeated();
        return sortedNewArray;
    }

}
