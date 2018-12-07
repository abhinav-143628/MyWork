package com.abhi.java.Collection;

import java.util.*;

/**
 * Created by abhdogra1 on 12/6/2018.
 */
public class ReverseMapIterator<T,K> extends ReverseIterator<T> {

    private Map<T,K> map;

    public ReverseMapIterator(Map<T,K> map){
        this.map = map;
    }
    @Override
    public Iterator<T> getIterator() {
        return this.iterator();
    }

    @Override
    public Iterator<T> iterator() {

        final List<T> list = new ArrayList<>(this.map.keySet());
        final ListIterator<T> listIterator = list.listIterator(list.size());

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return listIterator.hasPrevious();
            }

            @Override
            public T next() {
                return listIterator.previous();
            }
        };
    }
}
