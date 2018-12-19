package com.abhi.java.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by abhdogra1 on 12/13/2018.
 */
public class TestCollectionSync {

    public static void main(String[] args) {
        //Difference betweeen below collections
        Collections.synchronizedMap(new HashMap<String,Integer>()); // in this we can provide own mutex for locks
        Hashtable<String,Integer> tableMap = new Hashtable<>(); // in this we cannot, we all methods are sync
        Collections.unmodifiableList(new ArrayList<>()); // retruns intance of UnmodifiableList or UnmodifiableRandomAccessList in which they return UnsupportedOperationException for modifying operations except get, iterator and all
    }
}
