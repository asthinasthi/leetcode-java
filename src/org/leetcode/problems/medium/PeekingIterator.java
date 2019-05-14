package org.leetcode.problems.medium;
import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer nextElement;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        nextElement = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer temp = nextElement;
        if(iterator.hasNext())
            nextElement = iterator.next();
        else
            nextElement = null;
        return temp;
    }

    @Override
    public boolean hasNext() {
        return nextElement == null;
    }
}