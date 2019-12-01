package com.company;

import java.util.Arrays;

public class SortedNumberList {

    int[] source;

    public SortedNumberList() {
        this.source = new int[0];
    }

    public SortedNumberList(int[] array) {
        this.source = ArrayUtils.copyArray(array);
    }

    public void add(int value) { // add in accordance with sorted list
        boolean flag = false;
        for (int i = 0; i < source.length; i++) {
            if (source[i] >= value) {
                this.source = ArrayUtils.insert(this.source, i, value);
                flag = true;
                break;
            }
        }
        if (!flag) {
            this.source = ArrayUtils.insert(this.source, this.source.length, value);
        }
    }

    public int get(int index) {
        return this.source[index];
    }

    public int size() {
        return this.source.length;
    }

    public void removeById(int index) {

        int[] newArray = new int[source.length - 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = this.source[i];
        }

        for (int i = index + 1; i < source.length; i++) {
            newArray[i - 1] = source[i];
        }

        this.source = newArray;
    }

    public boolean remove(int value) {
        for (int i = 0; i < source.length; i++) {
            if (this.source[i] == value) {
                removeById(i);
                return true;
            }
        }
        return false;
    }

    public void removeRepeated() {

        for (int i = 0; i < source.length - 1; i++) {
            if (source[i] == source[i + 1]) {
                removeById(i);
                i--;
            }
        }
    }

    public SortedNumberList intersection(SortedNumberList array) {

        int[] newArray = ArrayUtils.copyArray(source);
        SortedNumberList sortedNewArray = new SortedNumberList(newArray);

        for (int i = 0; i < array.size(); i++) {
            sortedNewArray.add(array.get(i));
        }

        return sortedNewArray;
    }

    public SortedNumberList union(SortedNumberList array) {

        SortedNumberList sortedNewArray = intersection(array);
        sortedNewArray.removeRepeated();
        return sortedNewArray;
    }

    public String printArray() {
        return Arrays.toString(source);
    }

}
