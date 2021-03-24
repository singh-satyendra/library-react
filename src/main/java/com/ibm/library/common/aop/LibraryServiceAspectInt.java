package com.ibm.library.common.aop;

import org.aspectj.lang.JoinPoint;

@FunctionalInterface
public interface LibraryServiceAspectInt {
	
	void before(JoinPoint joinPoint);
	
    default void defaultMethod() {
        System.out.println("This is a default method");
    }
    
    //Static is similar to default methods. We can not override it in the implementing classes.
    static void staticMethod() {
        System.out.println("This is a static method");
    }

}
