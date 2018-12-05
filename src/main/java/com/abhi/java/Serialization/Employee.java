package com.abhi.java.Serialization;

/**
 * Created by abhdogra1 on 12/5/2018.
 */
public class Employee extends SecurityManager {

//    public Employee() throws Exception {
//        throw new Exception("Not Serilizable");
//    }

    @Override
    public void checkPackageAccess(String pkg){

        // don't allow the use of the reflection package
        if(pkg.equals("com.abhi.java.Serialization")){
            throw new SecurityException("Reflection is not allowed!");
        }
    }
}
