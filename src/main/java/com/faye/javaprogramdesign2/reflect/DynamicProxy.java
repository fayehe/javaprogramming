package com.faye.javaprogramdesign2.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author Faye F F HE
 * @Date 2019/2/27 22:38
 */
public class DynamicProxy {//客户端
    public static void main(String[] args) {
        realSubject2 realSubject2 = new realSubject2(); //指定被代理对象
        InvocationHandler ds = new DynamicSubject(realSubject2);
        Class cls = realSubject2.getClass();
        Subject2 subject2 = (Subject2) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);
        subject2.request();
    }
}

interface Subject2{ //真实角色与代理角色的共同接口
    public void request();
}
class realSubject2 implements Subject2{ //真实角色
    @Override
    public void request() {
        System.out.println("from real subject 2");
    }
}
class DynamicSubject implements InvocationHandler{ //代理角色，必须实现InvokeHandler
    private Object sub;
    public DynamicSubject(){}
    public DynamicSubject(Object obj){sub = obj;}

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("before calling method: " + method);
        method.invoke(sub, args);
        System.out.println("after calling method: " + method);
        return null;
    }
}