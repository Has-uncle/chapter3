package com.example.chapter4.proxys;

import com.example.chapter4.filters.Interceptor;
import com.example.chapter4.invokes.Invocation;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class ProxyBean implements InvocationHandler {
    private Object target = null;
    private Interceptor interceptor = null;
//    private org.aopalliance.intercept.Interceptor
    /**
     * 绑定代理对象
     * target:被代理对象
     * interceptor :拦截器
     * return：代理对象
     * */
    public static Object getProxyBean(Object target, Interceptor interceptor){
        ProxyBean proxyBean = new ProxyBean();
        //保存代理对象
        proxyBean.target = target;
        //保存拦截器
        proxyBean.interceptor = interceptor;
        //生成代理对象
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),proxyBean);
        //返回代理对象
        return proxy;
    }
    /**
     * 处理代理对象方法逻辑
     * o: 代理方法
     * method：当前方法
     * objects:运行参数
     * return :方法调用结果
     * throws：有异常
     * */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        //异常标识
        boolean exeptionFlag = false;
        Invocation invocation = new Invocation(objects,method,target);
        Object retObj = null;
        try{
            if (this.interceptor.before()){
                retObj = this.interceptor.around(invocation);
            }else {
                retObj = method.invoke(target,objects);
            }
        }catch (Exception e){
            exeptionFlag = true;
        }
        this.interceptor.after();
        if (exeptionFlag == false){
            this.interceptor.afterThrowing();
        }else {
            this.interceptor.afterReturning();
            return retObj;
        }
        return null;
    }
}
