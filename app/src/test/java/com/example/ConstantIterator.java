package com.example;

public class ConstantIterator implements Iterator {

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public int next() {
        return 0;
    }
}
