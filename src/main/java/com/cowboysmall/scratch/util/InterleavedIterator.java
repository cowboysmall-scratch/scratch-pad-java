package com.cowboysmall.scratch.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class InterleavedIterator<E> implements Iterator<E> {

    private final List<Iterator<E>> iterators = new LinkedList<>();

    @SafeVarargs
    public InterleavedIterator(Iterator<E>... iterators) {

        for (Iterator<E> iterator : iterators)
            if (iterator.hasNext())
                this.iterators.add(iterator);
    }

    @Override
    public boolean hasNext() {

        return iterators.size() > 0;
    }

    @Override
    public E next() {

        if (iterators.size() == 0)
            throw new NoSuchElementException();

        Iterator<E> iterator = iterators.remove(0);
        E next = iterator.next();
        if (iterator.hasNext())
            iterators.add(iterator);
        return next;
    }
}
