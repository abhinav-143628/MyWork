package com.abhi.java.Collection;

import java.util.Iterator;

/**
 * Iterable internally call iterator() which returns Iterator which can be used to iterate over the objects.
 * Implementing Iterable on a class just gives us ability to override iterator() and not hasNext() and next() (remove() and forEachRemaining() are other methods as well)
 * So per my understanding if we have to implement our own custom iterator we need to implement Iterable(Interface in our class) and then return itertor back to the user
 * <p>
 *
 * Created by abhdogra1 on 12/6/2018.
 */
public abstract class ReverseIterator<T> implements Iterable<T> {

    public abstract Iterator<T> getIterator();
}
