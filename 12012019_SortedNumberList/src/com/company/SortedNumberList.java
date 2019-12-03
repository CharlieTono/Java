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
     * @param index of the element to remove
     * @return removed element
     */

    public int removeById(int index) {

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

        int newSize = 0;   //Option#2 with method contains

        for (int i = 0; i < this.source.length; i++) {
            if (array.contains(source[i])) {
                newSize++;
            }
        }

        int [] newArray = new int [newSize];
        int index = 0;
        for (int i = 0; i < source.length; i++) {
            if (array.contains(source[i])) {
                newArray[index++] = source[i];
            }
        }
        SortedNumberList sortedNewArray = new SortedNumberList(newArray);
        sortedNewArray.removeRepeated();
        return sortedNewArray;
    }

    public SortedNumberList union(SortedNumberList array) {

        int[] newArray = new int[this.source.length + array.size()];

        for (int i = 0; i < this.source.length; i++) {
            newArray[i] = source[i];
        }
        for (int i = 0; i < array.size(); i++) {
            newArray[i + source.length] = array.source[i];
        }

        SortedNumberList sortedNewArray = new SortedNumberList(newArray);
        sortedNewArray.removeRepeated();

        return sortedNewArray;
    }

    public boolean contains (int number) {
        int index = ArrayUtils.binarySearch(this.source, number);
        return index >= 0;
    }

}
