package com.abhi.java.PrepGS;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.JUnitCore;

/**
 * Created by abhdogra1 on 2/7/2019.
 */

/*
**  The below pattern of numbers are called Pascals Triangle.
**
**  Pascals Triangle exhibits the following behaviour:
**
**  The first and last numbers of each row in the triangle are 1
**  Each number in the triangle is the sum of the two numbers above it.
**
**  Example:
**               1
**              1 1
**             1 2 1
**            1 3 3 1
**           1 4 6 4 1
**         1 5 10 10 5 1
**        1 6 15 20 15 6 1
**
**  Please Complete the 'pascal' function below so that given a
**  col and a row it will return the value in that positon.
**
**  Example, pascal(1,2) should return 2
**
*/
public class PascalTriangle {

    /*Asserts on value returned from pascal */
    @Test
    public void doTestsPass(){
        Assert.assertTrue(PascalTriangle.pascal(0,0) ==  1);
        Assert.assertTrue(PascalTriangle.pascal(1,2) ==  2);
        Assert.assertTrue(PascalTriangle.pascal(5,6) ==  6);
    }

    public static int pascal( int Col, int Row ){
        return 0;
    }

    public static void main(String[] args) {
        JUnitCore.main("Solution");
    }
}
