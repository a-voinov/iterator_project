package com.example;

import java.util.List;
import java.util.StringJoiner;

public class TestData {
    private final String testName;
    private List<Integer> expectedValues;
    private List<Iterator> iterators;

    public static TestData of(String testName, List<Integer> expectedValues, List<Iterator> iterators) {
        return new TestData(testName, expectedValues, iterators);
    }

    public TestData(String testName, List<Integer> expectedValues, List<Iterator> iterators) {
        this.testName = testName;
        this.expectedValues = expectedValues;
        this.iterators = iterators;
    }

    public List<Integer> getExpectedValues() {
        return expectedValues;
    }

    public void setExpectedValues(List<Integer> expectedValues) {
        this.expectedValues = expectedValues;
    }

    public List<Iterator> getIterators() {
        return iterators;
    }

    public void setIterators(List<Iterator> iterators) {
        this.iterators = iterators;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TestData.class.getSimpleName() + "[", "]")
                .add("testName='" + testName + "'")
                .toString();
    }
}
