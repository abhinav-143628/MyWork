package com.abhi.java.Generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by abhdogra1 on 12/5/2018.
 */
public class GenericBasics {


    public static <T> void printList(T... x) {
        List<T> list = new ArrayList<T>();
        for (T t : x) {
            list.add(t);
        }

        for (T t : list) {
            System.out.println(t);
        }
    }

    public static <T> void printList2(T[] f, Collection<T> e) {
        for (T a : f) {
            e.add(a);
            System.out.println(a);
        }
    }

    public static <T> void printList3(T f, T e) {
        f = e;
        System.out.println(f);
    }

    public void printList123(List<? extends Number> ls) {
        Object ob = ls.get(0);

    }

    //Will give error to below printList1234 saying that both methods have same erasure if we uncomment below method
//    public void printList1234(List<Collection<String>> ls){
//        Object ob = ls.get(0);
//    }

    public void printList1234(List<Set<String>> ls) {
        Object ob = ls.get(0);
    }

    public static void main(String[] args) {

        List list = new ArrayList<Integer>();
        list.add("String");
        list.add(1);

        List<String> list1 = new ArrayList();
        list1.add("String");
        //list1.add(1);

        List<Integer> list2 = new ArrayList(list1);
        //List<Integer> list3 = new ArrayList<>(list1);

        List list4 = new ArrayList<Integer>();
        list4.add(123);
        list4.add("123");
        //list2.add("String");
        //list2.add(1);

        printList("abc", "xtyz", 123);
        GenericBasics.<String>printList("abc", "xtyz", "123");

        //<String>printList("abc","xtyz","123");

        String[] ab = {"abs"};
        List<String> ls = new ArrayList<>();
        printList2(ab, ls);

        List<Integer> ls1 = new ArrayList<>();
        //This will give error as type of both should be same or Object is allowed
//        printList2(ab,ls1);

        List<Object> ls2 = new ArrayList<>();
        printList2(ab, ls2);

        //This will change to Object, Object after type Erasure
        printList3(1, "String");
    }
}
