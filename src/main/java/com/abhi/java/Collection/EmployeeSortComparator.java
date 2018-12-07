package com.abhi.java.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sort employee obj list based on last name. All employees having last name should be sorted ascending order based on last name.
 * if last name is empty then all those employees should be at the last of the list but also all these employees with no last name should be sorted based on first name in descending oder
 * <p>
 * Created by abhdogra1 on 12/6/2018.
 */
public class EmployeeSortComparator implements Comparator<EmployeeSort> {

    @Override
    public int compare(EmployeeSort o1, EmployeeSort o2) {
        boolean firstLastName = o1.getLastName().isEmpty();
        boolean secondLastName = o2.getLastName().isEmpty();
        if (!firstLastName && !secondLastName) {
            return o1.getLastName().compareTo(o2.getLastName());
        } else if (!firstLastName) {
            return -1;
        } else if (!secondLastName) {
            return 1;
        } else
            return o2.getFirstName().compareTo(o1.getFirstName());
    }

    public static void main(String[] args) {
        List<EmployeeSort> list = new ArrayList<>();

        EmployeeSort obj = new EmployeeSort();
        obj.setFirstName("Abhi");
        obj.setLastName("ctwo");

        EmployeeSort obj1 = new EmployeeSort();
        obj1.setFirstName("BAbhi");
        obj1.setLastName("wtwo");

        EmployeeSort obj2 = new EmployeeSort();
        obj2.setFirstName("Abhi");
        obj2.setLastName("");

        EmployeeSort obj3 = new EmployeeSort();
        obj3.setFirstName("DAbhi");
        obj3.setLastName("atwo");

        EmployeeSort obj4 = new EmployeeSort();
        obj4.setFirstName("CAbhi");
        obj4.setLastName("");

        list.add(obj);
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);

        Collections.sort(list, new EmployeeSortComparator());

        for (EmployeeSort e : list) {
            System.out.println(e.getFirstName() + " " + e.getLastName());
        }
    }
}
