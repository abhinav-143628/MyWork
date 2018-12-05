package com.abhi.java.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by abhdogra1 on 12/4/2018.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface MyAnnotation {
    String name();
    int value() default 10;
}
