package com.example.chapter4.filters.impl;

import com.example.chapter4.filters.Interceptor;
import com.example.chapter4.invokes.Invocation;


import java.lang.reflect.InvocationTargetException;

public class InterceptorImpl implements Interceptor {
    @Override
    public boolean before() {
        System.out.println("******  this is before  *******");
        return true;
    }

    @Override
    public void after() {
        System.out.println("******  this is after  ********");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        Object obj = null;
        System.out.println("*******  this is around  *********");
        try {
            obj = invocation.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("*******  around after  ********");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("*********  this is afterReturning  *******");
    }

    @Override
    public void afterThrowing() {
        System.out.println("*********  this is Trowing  ***********");
    }

    @Override
    public boolean useAround() {
        return false;
    }
}
