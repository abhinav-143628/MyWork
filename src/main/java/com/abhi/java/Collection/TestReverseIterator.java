package com.abhi.java.Collection;

import java.util.*;

/**
 * Created by abhdogra1 on 12/6/2018.
 */
public class TestReverseIterator {

    public static void main(String [] args){
        List<String> ac = new ArrayList<>();
        ac.add("abc");
        ac.add("obs");
        ac.add("zsd");

        for(String s : ac)
            System.out.println(s);

        ReverseIterator<String> it = new ReverseListIterator<String>(ac);
        Iterator<String> iter = it.getIterator();
        System.out.println("List after reverse iterator");
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        System.out.println("Using hashmap reverse iterator");
        Map<String,String> map = new HashMap<>();
        map.put("abc","first");
        map.put("obs","second");
        map.put("zsd","third");

        for(String  i : map.keySet())
            System.out.println(i);

        ReverseIterator<String> itMap = new ReverseMapIterator<String,String>(map);

        Iterator<String> iterMap = itMap.getIterator();
        System.out.println("Map after reverse iterator");
        while(iterMap.hasNext()){
            System.out.println(iterMap.next());
        }
    }
}
