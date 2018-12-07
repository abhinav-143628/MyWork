package com.abhi.java.Collection;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by abhdogra1 on 12/6/2018.
 */
public class EmployeeSortComparator implements Comparator<EmployeeSort> {

    @Override
    public int compare(EmployeeSort o1, EmployeeSort o2) {
        if (o1.getLastName().isEmpty() || o2.getLastName().isEmpty()) {
            return -1;
        } else
            o1.getFirstName().compareTo(o2.getFirstName());
        return 0;
    }

    public static void main(String[] args) {
        List<EmployeeSort> list = new ArrayList<>();

        EmployeeSort obj = new EmployeeSort();
        obj.setFirstName("Abhi");
        obj.setLastName("two");

        EmployeeSort obj1 = new EmployeeSort();
        obj.setFirstName("BAbhi");
        obj.setLastName("two");

        EmployeeSort obj2 = new EmployeeSort();
        obj.setFirstName("Abhi");
        obj.setLastName("");

        EmployeeSort obj3 = new EmployeeSort();
        obj.setFirstName("DAbhi");
        obj.setLastName("two");
        list.add(obj);


        EmployeeSort obj4 = new EmployeeSort();
        obj.setFirstName("CAbhi");
        obj.setLastName("");

        Collections.sort(list, new EmployeeSortComparator());

        for (EmployeeSort e : list) {
            System.out.println(e.getFirstName());
        }
    }
}
