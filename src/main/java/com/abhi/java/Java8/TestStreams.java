package com.abhi.java.Java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by abhdogra1 on 12/12/2018.
 */
public class TestStreams {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("a","b","c","d");
        List<Employee> list = new ArrayList<>();

        for(String name : names){
            System.out.println();
            list.add(lookUp(name));
        }

        String checker = "a";
        List<Employee> empNames =  names.stream().map((name) -> {
            System.out.println("-#############-" + name);
            return lookUp(name);
        }).filter(x-> {
            if(x.name.equals(checker))
                return true;
            else
                return false;
        }).collect(Collectors.toList());

        for(Employee e : empNames)
            System.out.println("After filter"+e.name);

        //Bi-function
        Map<Integer,String> mapEmp = new HashMap<>();

        mapEmp.put(1,"ad1");
        mapEmp.put(2,"ad2");
        mapEmp.put(3,"ad3");
        mapEmp.put(4,"ad4");

        mapEmp.forEach((Integer key, String value) ->{
            System.out.println(key+ "++++++++++++"+value);
        });

    }

    private static Employee lookUp(String a){
        Employee e = new Employee();
        e.name = a;
        return e;
    }

    static class Employee{
        private int id;
        private String name;
    }
}
