package com.company;

import java.util.Arrays;

public class Array {

    int[] source;

    public Array() {
        this.source = new int[0];
    }

    public Array(int[] source) {
        this.source = ArrayUtils.copyArray(source);
    }

    public void set(int index, int value) {
        this.source[index] = value;
    }

    public int get(int index) {
        return this.source[index];
    }

    public int size() {
        return this.source.length;
    }

    /**
     * adds the value to the end of the current object
     *
     * @param value element to add
     */

    public void append(int value) {
        this.source = ArrayUtils.append(this.source, value);
    }

    public void insert(int index, int value) {
        this.source = ArrayUtils.insert(this.source, index, value);
    }

    public void removeById(int index) {

        int[] newArray = new int[source.length - 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = source[i];
        }

        newArray[index] = source[index + 1];

        for (int i = index + 1; i < newArray.length; i++) {
            newArray[i] = source[i + 1];
        }

        this.source = newArray;
    }

    public boolean remove(int element) {
        for (int i = 0; i < source.length; i++) {
            if (this.source[i] == element) {
                removeById(i);
                return true;
            }
        }
        return false;
    }

    public int findMax() {
        int max = source[0];
        for (int i = 1; i < source.length; i++) {
            if (source[i] > max) {
                max = source[i];
            }
        }
        return max;
    }

    public int findMin() {
        int min = source[0];
        for (int i = 0; i < source.length; i++) {
            if (source[i] < min) {
                min = source[i];
            }
        }
        return min;
    }

    public String toString() {
        return Arrays.toString(source);
    }
}
