package com.example;

import java.util.*;

public class SuperIterator implements Iterator {

    private final Map<Iterator, Integer> iteratorValues = new HashMap<>();

    public SuperIterator(Collection<Iterator> iterators) {
        if (iterators == null) {
            iterators = new ArrayList<>();
        }

        for (Iterator iterator : iterators) {
            if (iterator != null && iterator.hasNext()) {
                iteratorValues.put(iterator, iterator.next());
            }
        }
    }

    @Override
    public boolean hasNext() {
        return iteratorValues.keySet().stream().anyMatch(Iterator::hasNext);
    }

    @Override
    public int next() {
        if (!hasNext()) {
            throw new IllegalStateException();
        }

        int min = Integer.MAX_VALUE;
        Iterator minIterator = null;

        for (Map.Entry<Iterator, Integer> entry : iteratorValues.entrySet()) {
            Iterator iterator = entry.getKey();
            Integer value = entry.getValue();

            if (value == null) {
                continue;
            }

            if (min > value) {
                min = value;
                minIterator = iterator;
            }
        }

        iteratorValues.put(minIterator, minIterator.hasNext() ? minIterator.next() : null);

        return min;
    }
}
