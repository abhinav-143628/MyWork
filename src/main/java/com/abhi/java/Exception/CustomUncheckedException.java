package com.abhi.java.Exception;

import java.io.UncheckedIOException;

/**
 *
 * Unchecked exception can be created by extedning RuntimeException class
 * Created by abhdogra1 on 12/4/2018.
 */


public class CustomUncheckedException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public CustomUncheckedException(String message){
        super(message);
    }

    public CustomUncheckedException() {
        super();
    }

    public CustomUncheckedException(String message, Throwable cause){
        super(message, cause);
    }

}
