package com.abhi.java.Exception;

/**
 * Created by abhdogra1 on 12/4/2018.
 */
public class CustomCheckedExeption extends Exception {

    //As Exception extedns from Throwable and throwable implements Serilizable it is adviced to have serialVersionUID in exception classes
    private static final long serialVersionUID = 1L;


    public CustomCheckedExeption(String message){
        super(message);
    }

    public CustomCheckedExeption(String message, Throwable cause){
        super(message, cause);
    }

}
