package com.company;

import java.util.Iterator;

public class ArrIterator implements Iterator {
    private int pos=0;
    int [][] arr;

    public ArrIterator(int[][] arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        if (pos<arr.length-1){
            return true;
        }
        else return false;
    }

    @Override
    public Object next() {
        return (arr[++pos]);
    }
}
