package com.abhi.java.Exception;

/**
 * Created by abhdogra1 on 12/4/2018.
 */
public class TestExceptionClass {

    public void checkCustomCheckedException() throws CustomCheckedExeption {
        int i = 2;
        try {
            int k = i / 0;
        }catch (Exception e){
            throw new CustomCheckedExeption("Error occured");
        }
    }

    public void checkCustomUnCheckedException() throws CustomUncheckedException {
        int i = 2;
        try {
            int k = i / 0;
        }catch (Exception e){
            throw new CustomUncheckedException("Error occured at runtine");
        }
    }

    public static void main(String[] args) {
        TestExceptionClass obj = new TestExceptionClass();

        try {
            obj.checkCustomCheckedException();
        } catch (CustomCheckedExeption customCheckedExeption) {
            customCheckedExeption.printStackTrace();
        }
        ;
        obj.checkCustomUnCheckedException();
    }
}
