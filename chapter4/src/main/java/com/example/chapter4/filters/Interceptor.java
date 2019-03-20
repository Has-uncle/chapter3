package com.example.chapter4.filters;



import com.example.chapter4.invokes.Invocation;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {
    //前置方法
    public boolean before();
    //后置方法
    public void after();
    //环绕方法
    /**
     * 取代原有事件
     * invocation:回调参数，可以通过他的proceed方法，回调原有事件
     * return :原有事件返回对象
     * */
    public Object around(Invocation invocation) throws InvocationTargetException,IllegalAccessException;
    //时间没有发生异常执行，返回方法
    public void afterReturning();
    //事件发生异常时执行
    public void afterThrowing();
    //是否使用around方法
    boolean useAround();
}
