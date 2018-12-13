package com.abhi.java.Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by abhdogra1 on 12/12/2018.
 */
public class GenericsTest {

    Integer[] abc = {1,2,3,2};
    Number[] abc1 = abc;


//    Number[] abcd1 = {1,2,3,2};
//    Integer[] abcd = abcd1;
//
//    List<Integer> abc11 = new ArrayList<>();
//    List<Number> abc12 = abc11;
//
//    List<Number> abc111 = new ArrayList<>();
//    List<Integer> abc112 = abc111;

    public static void getList(List<? extends Number> list){
        List<? super Number> nList = new ArrayList<>();
        for(Number n : list){
            nList.add(n);
        }
       // list.add(null);
    }

    public static void main(String[] args) {
        List<Float> flist = Arrays.asList(1.2f,2.4f,2.2f);
        List<Integer> ilist = Arrays.asList(1,2,2);

        getList(flist);
        getList(ilist);
    }



}
