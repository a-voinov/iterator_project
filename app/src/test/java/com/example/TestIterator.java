package com.example;

import java.util.Arrays;
import java.util.Collection;

public class TestIterator implements Iterator {

    private final java.util.Iterator<Integer> c;

    public static TestIterator of(Integer... c) {
        return new TestIterator(Arrays.asList(c));
    }

    public TestIterator(Collection<Integer> c) {this.c = c.iterator();}

    @Override
    public boolean hasNext() {
        return c.hasNext();
    }

    @Override
    public int next() {
        return c.next();
    }
}
