package com.abhi.java.core;

/**
 * Created by abhdogra1 on 1/24/2019.
 */
public class TestCasting {
    public static void main(String[] args) {
        //upcasting
        Animal animal =  new Cat();
        animal.eat();
        animal.myAnimal();
        ((Cat) animal).myCatMethod();

        Cat c = (Cat) animal;
        c.myCatMethod();
        c.myAnimal();

         //runtime exception
        //downcasting, not allowed in Java at runtime
//        Cat c1 = (Cat) new Animal();
//        c1.myAnimal();
//        c1.myCatMethod();

    }
}
