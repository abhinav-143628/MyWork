package com.abhi.java.Collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by abhdogra1 on 12/13/2018.
 */
public class TestCollectionSync {

    public static void main(String[] args) {
        //Difference betweeen below 2
        Collections.synchronizedMap(new HashMap<String,Integer>());
        Hashtable<String,Integer> tableMap = new Hashtable<>();
    }
}
