package com.abhi.java.Serialization;

import java.io.Serializable;

/**
 * Created by abhdogra1 on 12/4/2018.
 */
public class SerializableNoReflection extends SecurityManager implements Serializable {

    @Override
    public void checkPackageAccess(String pkg){

        // don't allow the use of the reflection package
        if(pkg.equals("com.abhi.java.Serialization")){
            throw new SecurityException("Reflection is not allowed!");
        }
    }

    private final String test;
    public SerializableNoReflection(String abc){
        this.test = abc;
    }
}
