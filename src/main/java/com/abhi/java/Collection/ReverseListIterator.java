package com.abhi.java.Collection;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by abhdogra1 on 12/6/2018.
 */
public class ReverseListIterator<T> extends ReverseIterator<T> {

    private List<T> list;

    public ReverseListIterator(List<T> list) {
       this.list = list;
    }

    @Override
    public Iterator<T> iterator() {

        final ListIterator<T> iteratorL = list.listIterator(list.size());
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return iteratorL.hasPrevious();
            }

            @Override
            public T next() {
                return iteratorL.previous();
            }
        };
    }

    @Override
    public Iterator<T> getIterator() {
        return this.iterator();
    }
}
