package com.abhi.java.core;

/**
 * Created by abhdogra1 on 12/4/2018.
 */
public class TryWithResourcesTest implements AutoCloseable {
    public void print() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        //we can't create a reference variable outside of try(), it will not accept it.
        TryWithResourcesTest t;
        //if we don't implement AutoClosable interface this try-with-resource will give compile time error saying 'Incompatible types, required autocloseable'
        try (TryWithResourcesTest t1 = new TryWithResourcesTest()) {

        } catch (Exception e) {

        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("close method called");
    }
}
